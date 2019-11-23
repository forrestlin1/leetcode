package org.forrestlin.jianzhioffer;

/*
 * 1~n的整数中1出现的次数
 * */
public class L31NumberOf1Between1AndN {


    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}
