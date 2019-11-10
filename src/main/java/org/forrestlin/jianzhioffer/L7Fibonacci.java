package org.forrestlin.jianzhioffer;

/*
 * 斐波那契数列
 * */
public class L7Fibonacci {

    public int Fibonacci(int n) {
        int f_0 = 0;
        int f_1 = 1;
        if (n == 0) {
            return f_0;
        }
        if (n == 1) {
            return f_1;
        }

        while (n >= 2) {
            int tmp = f_0;
            f_0 = f_1;
            f_1 = tmp + f_1;
            n--;
        }

        return f_1;
    }
}
