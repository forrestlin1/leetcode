package org.forrestlin.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 单词拆分
 * @author: forrestlin
 * @create: 2019-10-23 17:29
 */
public class L139WordBreak {


    public static void main(String[] args) {
        L139WordBreak test = new L139WordBreak();
        System.out.println(test.wordBreak("aaaaaaa", Arrays.asList(new String[]{"aaaa", "aaa"})));
    }

    boolean res = false;


    /**
     * 动态规划
     *
     * 这个方法的想法是对于给定的字符串（ss）可以被拆分成子问题 s1s1 和 s2s2 。如果这些子问题都可以独立地被拆分成符合要求的子问题，那么整个问题 ss 也可以满足。也就是，如果 "\text{catsanddog}catsanddog" 可以拆分成两个子字符串 "\text{catsand}catsand" 和 "\text{dog}dog" 。子问题 "\text{catsand}catsand" 可以进一步拆分成 "\text{cats}cats" 和 "\text{and}and" ，这两个独立的部分都是字典的一部分，所以 "\text{catsand}catsand" 满足题意条件，再往前， "\text{catsand}catsand" 和 "\text{dog}dog" 也分别满足条件，所以整个字符串 "\text{catsanddog}catsanddog" 也满足条件。
     *
     * 现在，我们考虑 \text{dp}dp 数组求解的过程。我们使用 n+1n+1 大小数组的 \text{dp}dp ，其中 nn 是给定字符串的长度。我们也使用 2 个下标指针 ii 和 jj ，其中 ii 是当前字符串从头开始的子字符串（s's ）的长度， jj 是当前子字符串（s's
     * ′
     * ）的拆分位置，拆分成  s(0,j) 和 s'(j+1,i)
     *
     * 为了求出 \text{dp}dp 数组，我们初始化 \text{dp}[0]dp[0] 为 \text{true}true ，这是因为空字符串总是字典的一部分。 \text{dp}dp 数组剩余的元素都初始化为 \text{false}false 。
     *
     * 我们用下标 ii 来考虑所有从当前字符串开始的可能的子字符串。对于每一个子字符串，我们通过下标 jj 将它拆分成 s1's1
     * ′
     * 和 s2's2
     * ′
     * （注意 ii 现在指向 s2's2
     * ′
     * 的结尾）。为了将 \text{dp}[i]dp[i] 数组求出来，我们依次检查每个 \text{dp}[j]dp[j] 是否为 \text{true}true ，也就是子字符串 s1's1
     * ′
     * 是否满足题目要求。如果满足，我们接下来检查 s2's2
     * ′
     * 是否在字典中。如果包含，我们接下来检查 s2's2
     * ′
     * 是否在字典中，如果两个字符串都满足要求，我们让 \text{dp}[i]dp[i] 为 \text{true}true ，否则令其为 \text{false}false 。
     */
    public boolean wordBreak0(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     * 回溯法，超时了
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        backTrace(s, wordDict);
        return res;
    }

    private void backTrace(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            res = true;
        }
        if (res) {
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {

                backTrace(s.substring(i), wordDict);
            }
        }


    }


    /**
     * 回溯法，记忆
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


}
