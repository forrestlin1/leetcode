package org.forrestlin.jianzhioffer;

/*
 * 跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * */
public class L8JumpFloor {

    public int JumpFloor(int target) {
        int n = target;
        int f_0 = 1;
        int f_1 = 2;
        if (n == 1) {
            return f_0;
        }
        if (n == 2) {
            return f_1;
        }

        while (n >= 3) {
            int tmp = f_0;
            f_0 = f_1;
            f_1 = tmp + f_1;
            n--;
        }

        return f_1;
    }
}
