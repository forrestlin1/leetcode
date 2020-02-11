package org.forrestlin.leetcode2;

/*
 * 比特位计数
 * */
public class L339CountingBits {

    /*
     * 迭代计算每个数字的位数1的个数
     * */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            ans[i] = popcount(i);
        }
        return ans;
    }

    /*
     * n与n-1相&，能够消除n的最后一个1
     * 不断循环直到n等于0为止
     * */
    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count) {
            x &= x - 1; //zeroing out the least significant nonzero bit
        }
        return count;
    }


    /*
     * x=(1001011101)2=(605)10
     * x ′=(100101110)2=(302) 10
     *可得状态转移方程如下
     * P(x)=P(x/2)+(xmod2)
     *
     * */
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            res[i] = res[i >> 1] + (i & 1);//i>>1等同于i/2;i&1等同于i%2
        }
        return res;

    }

}
