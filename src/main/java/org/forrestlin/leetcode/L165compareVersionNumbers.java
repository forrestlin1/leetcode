package org.forrestlin.leetcode;

/**
 * 比较版本号
 */
public class L165compareVersionNumbers {

    public static void main(String[] args) {
        L165compareVersionNumbers test = new L165compareVersionNumbers();
        System.out.println(test.compareVersion("1.0", "1.2"));
    }

    public int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int l1 = split1.length > split2.length ? split1.length : split2.length;
        for (int i = 0; i < l1; i++) {
            int v1 = 0;
            int v2 = 0;
            if (i < split1.length) {

                v1 = Integer.valueOf(split1[i]);
            }
            if (i < split2.length) {
                v2 = Integer.valueOf(split2[i]);
            }
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }

        }

        return 0;

    }
}
