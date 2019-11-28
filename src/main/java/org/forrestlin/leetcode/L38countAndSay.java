package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 报数
 * @author: forrestlin
 * @create: 2019-11-28 17:12
 */
public class L38countAndSay {

    public static void main(String[] args) {
        L38countAndSay test = new L38countAndSay();
        System.out.println(test.countAndSay(5));
    }

    public String countAndSay(int n) {
        String cur = "1";
        while (n > 1) {
            char cur_c = 'D';
            int cur_cnt = 1;
            StringBuilder sb = new StringBuilder();
            for (char c : cur.toCharArray()) {
                if (cur_c == 'D') {
                    cur_c = c;
                    cur_cnt = 1;
                } else if (c == cur_c) {
                    cur_cnt++;
                } else {
                    sb.append(cur_cnt).append(cur_c);
                    cur_c = c;
                    cur_cnt = 1;
                }

            }
            if (cur_c != 'D') {
                sb.append(cur_cnt).append(cur_c);
            }
            cur = sb.toString();
            n--;
        }
        return cur;
    }
}
