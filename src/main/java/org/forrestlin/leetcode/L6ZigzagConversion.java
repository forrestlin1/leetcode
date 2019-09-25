package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: Z字变换
 * @author: forrestlin
 * @create: 2019-09-19 15:30
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R       i%(n+1) = 0
 * E T O E S I I G     i%(n+1) = 1 ||i%(n+1) = 3
 * E   D   H   N       i%(n+1) = 2
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R       i%(n+2) = 0
 * E   O E   I I       i%(n+2) = 1 ||i%(n+2) = 5
 * E C   I H   N       i%(n+2) = 2 ||i%(n+2) = 4
 * T     S     G       i%(n+2) = 3
 *
 * L      I            i%(2n-2) = 0
 * E    E
 * E  D
 * TO
 * C
 */
public class L6ZigzagConversion {

    public static void main(String[] args) {
/**
 *P   I     N
 *A  L S  I G
 *Y A  H R
 *P    I
 * */
        System.out.println(convert("PAYPALISHIRING", 4));
    }


    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<String> resTmpLst = new ArrayList<>(numRows);
        for (int j = 0; j < numRows; j++) {
            resTmpLst.add("");
            for (int i = 0; i < s.length(); i++) {

                int cur = i % (2 * numRows - 2);
                int index;

                if (cur < numRows) {
                    index = cur;
                } else {
                    index = 2 * numRows - 2 - cur;
                }

                if (index != j) {
                    continue;
                }

                resTmpLst.set(index, resTmpLst.get(index) + s.charAt(i));
            }

        }

        String res = resTmpLst.stream().collect(Collectors.joining());

        return res;


    }


}
