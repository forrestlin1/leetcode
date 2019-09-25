package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 电话号码的字母组合
 * @author: forrestlin
 * @create: 2019-09-24 11:25
 */
public class L17LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {

        L17LetterCombinationsOfAPhoneNumber letter = new L17LetterCombinationsOfAPhoneNumber();
        System.out.println(letter.letterCombinations("234"));


    }

    Map<String, List<String>> numChars = new HashMap<String, List<String>>() {
        {
            put("2", Arrays.asList("a", "b", "c"));
            put("3", Arrays.asList("d", "e", "f"));
            put("4", Arrays.asList("g", "h", "i"));
            put("5", Arrays.asList("j", "k", "l"));
            put("6", Arrays.asList("m", "n", "o"));
            put("7", Arrays.asList("p", "q", "r", "s"));
            put("8", Arrays.asList("t", "u", "v"));
            put("9", Arrays.asList("w", "x", "y", "z"));

        }
    };

    public List<String> letterCombinations(String digits) {

        if (null == digits || "".equals(digits)) {
            return null;
        }

        return combine(digits);

    }

    public List<String> combine(String str) {

        if (str.length() == 1) {
            return numChars.get(str);
        } else {
            String subStr = str.substring(1, str.length());
            List<String> res = new ArrayList<>();

            List<String> chars = combine(subStr);

            List<String> curS = numChars.get(String.valueOf(str.charAt(0)));

            for (String c : curS) {
                List<String> resTmp = new ArrayList<>();
                for (String aChar : chars) {
                    resTmp.add(c + aChar);
                }
                res.addAll(resTmp);

            }

            return res;


        }


    }

}
