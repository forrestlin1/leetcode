package org.forrestlin.leetcode;

/**
 * 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L10regularExpressionMatching {

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        //首位是否匹配
        boolean isFirstMatch = (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));

        //pattern第二位是*
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            //匹配0次或者匹配1次
            return isMatch(text, pattern.substring(2)) || (isFirstMatch && isMatch(text.substring(1), pattern));
        } else {
            return isFirstMatch && isMatch(text.substring(1), pattern.substring(1));
        }


    }

/**
 * 动态规划
 *
 *（一）状态

 f[i][j]表示s1的前i个字符，和s2的前j个字符，能否匹配

 （二）转移方程

 如果s1的第 i 个字符和s2的第 j 个字符相同，或者s2的第 j 个字符为 “.”
 f[i][j] = f[i - 1][j - 1]
 如果s2的第 j 个字符为 *
 若s2的第 j 个字符匹配 0 次第 j - 1 个字符
 f[i][j] = f[i][j - 2] 比如(ab, abc*)
 若s2的第 j 个字符匹配至少 1 次第 j - 1 个字符,
 f[i][j] = f[i - 1][j] and s1[i] == s2[j - 1] or s[j - 1] == '.'
 这里注意不是 f[i - 1][j - 1]， 举个例子就明白了 (abbb, ab*) f[4][3] = f[3][3]

 （三）初始化

 f[0][i] = f[0][i - 2] && s2[i] == *
 即s1的前0个字符和s2的前i个字符能否匹配

 （四）结果

 *f[m][n]

 * */
    public boolean isMatch1(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for(int i = 2; i <= n; i++){
            f[0][i] = f[0][i - 2] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 2] ||
                        f[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                }
            }
        }

        return f[m][n];
    }

}
