package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 简化路径
 * @author: forrestlin
 * @create: 2019-12-05 11:08
 */
public class L71simplifyPath {

    public String simplifyPath(String path) {
        path = "/" + path + "/";
        String[] Stack = new String[500];
        int top = -1;
        int i = 0, j = 0;
        char[] ch = path.toCharArray();
        while (i < ch.length && j < ch.length) {
            while (i < ch.length && ch[i] == '/') {
                i++;
            }
            j = i;
            while (j < ch.length && ch[j] != '/') {
                j++;
            }
            if (i == ch.length || j == i) {
                break;
            }
            String cur = path.substring(i, j);

            if ("..".equals(cur)) {
                if (top != -1) {
                    --top;
                }
            } else if (".".equals(cur)) {
                /*do nothing*/
            } else {
                Stack[++top] = cur;
            }

            i = j;
        }

        String res = "/";
        for (int k = 0; k < top; k++) {
            res += Stack[k] + "/";
        }
        return res + (top >= 0 ? Stack[top] : "");
    }
}
