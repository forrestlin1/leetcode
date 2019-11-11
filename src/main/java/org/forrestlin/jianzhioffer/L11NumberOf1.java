package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 二进制中1的个数
 * @author: forrestlin
 * @create: 2019-11-11 16:51
 */
public class L11NumberOf1 {

    public static void main(String[] args) {
        L11NumberOf1 test = new L11NumberOf1();
        System.out.println(test.NumberOf1(7));
    }

    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

}
