package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 数组中重复的数字
 * @author: forrestlin
 * @create: 2019-11-19 16:37
 */
public class L50duplicate {

    /*
    * 数字归位法
    *
数组的长度为 n 且所有数字都在 0 到 n-1 的范围内，我们可以将每次遇到的数进行"归位"，当某个数发现自己的"位置"被相同的数占了，则出现重复。
扫描整个数组，当扫描到下标为 i 的数字时，首先比较该数字（m）是否等于 i，如果是，则接着扫描下一个数字；如果不是，则拿 m 与第 m 个数比较。如果 m 与第 m 个数相等，则说明出现重复了；如果 m 与第 m 个数不相等，则将 m 与第 m 个数交换，将 m "归位"，再重复比较交换的过程，直到发现重复的数
    *
    * */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }
}
