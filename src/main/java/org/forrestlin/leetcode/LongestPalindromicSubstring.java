package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 最长回文子串
 * @author: forrestlin
 * @create: 2019-09-17 09:56
 */
public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        longestPalindrome("bb");
    }


    /**
     * 动态规划
     * 首先定义 P(i，j）。
     *
     * P(i,j)=\begin{cases}true& \text{s[i,j]是回文串} \\\\false& \text{s[i,j]不是回文串}\end{cases}
     * P(i,j)=  true  s[i,j]是回文串
     * false  s[i,j]不是回文串
     * ​
     *
     * 接下来
     *
     * P(i,j)=(P(i+1,j−1)&&S[i]==S[j])
     *
     * 所以如果我们想知道 P（i,j）P（i,j）的情况，不需要调用判断回文串的函数了，只需要知道 P（i + 1，j - 1）P（i+1，j−1）的情况就可以了，这样时间复杂度就少了 O(n)O(n)。因此我们可以用动态规划的方法，空间换时间，把已经求出的 P（i，j）P（i，j）存储起来。
     * 如果 S[i+1,j-1]S[i+1,j−1] 是回文串，那么只要 S[ i ]S[i] == $S[ j ] $，就可以确定 S[i,j]S[i,j]也是回文串了。
     * 求 长度为 11 和长度为 22 的 P(i,j)P(i,j) 时不能用上边的公式，因为我们代入公式后会遇到 P[i][j]P[i][j] 中 i > j 的情况，比如求 P[1][2]P[1][2] 的话，我们需要知道 P[1+1][2-1]=P[2][1]P[1+1][2−1]=P[2][1] ，而 P[2][1]P[2][1] 代表着 S[2,1]S[2,1] 是不是回文串，显然是不对的，所以我们需要单独判断。
     * 所以我们先初始化长度是 11 的回文串的 P [ i , j ]P[i,j]，这样利用上边提出的公式 P(i,j)=(P(i+1,j-1)\&\&S[i]==S[j])P(i,j)=(P(i+1,j−1)&&S[i]==S[j])，然后两边向外各扩充一个字符，长度为 33 的，为 55 的，所有奇数长度的就都求出来了。
     * 同理，初始化长度是 22 的回文串 P [ i , i + 1 ]P[i,i+1]，利用公式，长度为 44 的，66 的所有偶数长度的就都求出来了。
     *
     *
     * */
    public static String longestPalindrome(String s) {
        if (null == s || s.length() == 1) {
            return s;
        }

        String res = "";
        int maxLen = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start < s.length(); start++) {

                int end = start + len - 1;
                //下标已经越界，结束本次循环
                if (end >= s.length()) {
                    break;
                }

                if ((len == 1 || len == 2 || dp[start + 1][end - 1]) &&
                    s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = true;
                } else {
                    dp[start][end] = false;

                }

                if (dp[start][end] && len > maxLen) {
                    res = s.substring(start, end + 1);
                    maxLen = res.length();
                }


            }
        }

        return res;
    }

}
