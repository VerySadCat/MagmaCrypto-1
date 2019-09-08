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
        // делим исходный пополам и копируем в 2 битсета по 32 бита
        bits[0] = block.get(0, 32);
        bits[1] = block.get(32, 64);

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

    // циклический сдвиг вправо (если нулевой бит справа) 0001 -> 0010
    private BitSet cycleShiftRight(BitSet bits, int bsize, int k) {
        BitSet bitsForShift = new BitSet();

        for(int j = 0; j < bsize-k; j++)
            bitsForShift.set(j, bits.get(j+k)); // выполняем простой сдвиг
        for (int j = 0; j < k; j++)
            bitsForShift.set(j+bsize-k, bits.get(j)); // записываем с образовавшихся нулей потерянную часть битов

        return bitsForShift; // переносим обратно в переменную
    }
    // циклический сдвиг влево (если нулевой бит справа) 0001 -> 0010
    private BitSet cycleShiftLeft(BitSet bits, int bsize, int k) {
        BitSet bitsForShift = new BitSet();

        for(int j = 0; j < bsize-k; j++)
            bitsForShift.set(j+k, bits.get(j)); // выполняем простой сдвиг, перенося биты в лево
        for (int j = 0; j < k; j++)
            bitsForShift.set(j, bits.get(j+bsize-k)); // записываем с образовавшихся нулей потерянную часть битов

        return bitsForShift; // переносим обратно в переменную
    }

    // сумма
    private BitSet addBitSet(BitSet left, BitSet right, int size) {
        BitSet bits = new BitSet(size);

        // TODO add

        return bits;
    }





    // DEBUG
    private void showBitSet(BitSet a, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(a.get(i) == true ? 1 : 0);

        System.out.println();
    }

    public void debug() {
        BitSet sss = new BitSet(64);

        for(int i = 0; i < 64; i++)
            sss.set(i, true);
        sss.set(0, false);
        sss.set(32, false);

        block64Proc(sss);
    }

}
