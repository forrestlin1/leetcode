package org.forrestlin.jianzhioffer;

/*
 * 矩形覆盖
 *
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */
public class L10RectCover {

    /*
     *
     *n = 1 的时候
     *只能横着覆盖，一种
     *n = 2 的时候
     *可以横着和竖着覆盖，两种
     *n = 3 的时候
     *第三级横着覆盖，用了一级，剩下 n = 2，有两种覆盖方法
     *第三季竖着覆盖，用了两级，剩下 n = 1，有一种覆盖方法
     *总共有 3 种
     *
     *
     *动态规划，f(n) = f(n-1)+f(n-2)
     *
     * */
    public int RectCover(int target) {
        if (target <= 1) {
            return target;
        }
        int f1 = 1;
        int f2 = 2;

        while (target >= 3) {
            int tmp = f1;
            f1 = f2;
            f2 = tmp + f1;
            target--;
        }
        return f2;

    }

}
