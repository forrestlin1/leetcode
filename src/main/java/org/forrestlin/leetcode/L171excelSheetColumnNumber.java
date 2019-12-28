package org.forrestlin.leetcode;
/**
 * Excel表列序号
 * */
public class L171excelSheetColumnNumber {

    public static void main(String[] args) {
        L171excelSheetColumnNumber test = new L171excelSheetColumnNumber();
        System.out.println(test.titleToNumber("AA"));
    }

    public int titleToNumber(String s) {
        int res = 0;
        int step = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = s.charAt(i) - 'A' + 1;
            res += n * step;
            step *= 26;
        }
        return res;
    }

}
