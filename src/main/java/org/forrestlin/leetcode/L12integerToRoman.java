package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 整数转罗马数字
 * @author: forrestlin
 * @create: 2019-11-22 16:14
 */
public class L12integerToRoman {

    public static void main(String[] args) {
        L12integerToRoman test = new L12integerToRoman();
        System.out.println(test.intToRoman(2000));
    }

    public String intToRoman(int num) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String res = "";

        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res += reps[i];
            }
        }
        return res;

    }
}
