package org.forrestlin.leetcode;
/**
 * 颠倒二进制位
 * */
public class L90reverseBits {
    public int reverseBits(int n) {
        int a=0;
        for(int i=0;i<=31;i++){
            a=a+((1&(n>>i))<<(31-i));
        }
        return a;
    }
}
