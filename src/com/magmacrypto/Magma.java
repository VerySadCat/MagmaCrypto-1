package com.magmacrypto;

import java.util.BitSet;

public class Magma {
    BitSet[] key; // 256 bits (32 bytes)
    BitSet[] target; // block = 64 bits (8 bytes)
    String targetText;



    // установить ключ шифрования
    public void setKey(String key) {
        this.key = stringTextToBitSet(key, 8, 32); // 8 ключей по 32 бита
    }

    // зашифровать
    public String crypt(String sourceText) {
        // текст в битсет
        target = stringTextToBitSet(sourceText, sourceText.length()/8, 64);

        for (int i = 0; i < 31; i++) { // раунды
            target[i] = block64Proc(target[i]);
        }

        // TODO обработка последней итерации

        return null; //target
    }

    // TODO decrypt
    // расшифровать
    public String decrypt(String sourceText) {

        return null;
    }

    // обработать блок (вызывается из цикла), принимает бло 64 бита
    private BitSet block64Proc(BitSet block) {
        BitSet[] bits = new BitSet[2];
        for (int i = 0; i < 32; i++) {
            // делим исходный пополам и копируем в 2 битсета
            bits[0].set(i, block.get(i));
            bits[1].set(i+32, block.get(i+32));
        }

        // TODO block proc

        return null;
    }

    // преобразование текста из target в BitSet на основе кодов символов (ASCII)
    private BitSet[] stringTextToBitSet(String sourceText, int m, int n) {
        BitSet[] bits = createEmptyBitSetMas(m, n);

        // TODO check bits alignment - little or big endian

        return null;
    }
    // обратное преобразование
    private String bitSetToStringText(BitSet[] sourceBits) {


        // TODO

        return null;
    }

    /** Создание пустого массива bitset
     * @param m block count
     * @param n bits in block
     * @return empty bitset
     */
    private BitSet[] createEmptyBitSetMas(int m, int n) {
        BitSet[] bits = new BitSet[m]; // кол-во блоков
        for (BitSet k : bits)
            k = new BitSet(n); // кол-во бит в блоке

        return bits;
    }

    // циклический сдвиг влево (если нулевой бит справа) 0001 -> 0010.
    // Пишет в ту же переменную
    private void cycleShiftLeft(BitSet bits, int i) {
        // TODO shift
    }
    // сумма
    private BitSet addBitSet(BitSet left, BitSet right) {
        if (left.size() == right.size()) {
            BitSet bits = new BitSet(left.size());

            // TODO add

            return bits;
        }
        else
            return null;
    }
}
