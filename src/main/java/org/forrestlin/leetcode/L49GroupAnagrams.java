package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 字母异词分组
 * @author: forrestlin
 * @create: 2019-10-14 18:16
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 *
 */
public class L49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> mapList = new HashMap<>();

        for (String str : strs) {
            String sortedStr = sortStr(str);
            List<String> keyList = mapList.get(sortedStr);
            if (null == keyList) {
                keyList = new ArrayList<>();
                keyList.add(str);
                mapList.put(sortedStr, keyList);
            } else {
                keyList.add(str);
            }

        }

        return new ArrayList<>(mapList.values());


    }

    private String sortStr(String str) {
        if ("".equals(str)) {
            return str;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }
}
