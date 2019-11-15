package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @program: leetcode
 * @description: 字符串的排列
 * @author: forrestlin
 * @create: 2019-11-15 10:06
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class L27Permutation {

    public static void main(String[] args) {
        L27Permutation test = new L27Permutation();
        System.out.println(test.Permutation("aa"));
    }

    ArrayList<String> result = new ArrayList<>();
    TreeSet<String> treeSet = new TreeSet<>();


    public ArrayList<String> Permutation(String str) {

        if (null == str || 0 == str.length()) {
            return result;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        LinkedList<Character> newChr = new LinkedList<>();
        for (char aChar : chars) {
            newChr.add(aChar);
        }

        backTrace(newChr, "");
        result.addAll(treeSet);
        return result;
    }

    private void backTrace(LinkedList<Character> chr, String res) {
        if (chr.size() == 0) {
            treeSet.add(res);
        }
        for (int i = 0; i < chr.size(); i++) {
            String newRes = res + chr.get(i);
            LinkedList<Character> newChr = new LinkedList<>(chr);
            newChr.remove(i);
            backTrace(newChr, newRes);
        }
    }
}
