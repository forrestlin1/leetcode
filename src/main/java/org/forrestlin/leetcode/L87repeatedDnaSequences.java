package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列
 */
public class L87repeatedDnaSequences {


    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> tmp = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (tmp.contains(sub)) {
                res.add(sub);
            } else {
                tmp.add(sub);
            }
        }
        return new ArrayList<>(res);
    }
}
