package org.forrestlin.jianzhioffer;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 构建数组乘积
 * @author: forrestlin
 * @create: 2019-11-20 11:35
 */
public class L51multiply {

    public static void main(String[] args) {
        L51multiply test = new L51multiply();
        System.out.println(Arrays.toString(test.multiply(new int[]{2, 2, 2}
        )));
    }

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp = tmp * A[i + 1];
            B[i] *= tmp;
        }

        return B;

    }


}
