package org.forrestlin.leetcode;

/*
 * 位1的个数
 * */
public class L191NumberOfBits {

    /*
     * 使用掩码与原数字相&，得到1则技术加一
     * */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    /*
     * n与n-1相&，能够消除n的最后一个1
     * 不断循环直到n等于0为止
     * */
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


}
