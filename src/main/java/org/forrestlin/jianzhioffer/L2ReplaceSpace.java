package org.forrestlin.jianzhioffer;

/*
 * 替换空格
 * */
public class L2ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        for (char c : str.toString().toCharArray()) {
            if (' ' == c) {
                res.append("%20");
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}
