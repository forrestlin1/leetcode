package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 扑克牌顺子
 * @author: forrestlin
 * @create: 2019-11-18 19:52
 */
public class L45isContinuous {

    public static void main(String[] args) {
        L45isContinuous test = new L45isContinuous();
        System.out.println(test.isContinuous(new int[]{1, 2, 3, 4, 7}));
    }

    public boolean isContinuous(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            return false;
        }
        int[] shun = new int[numbers.length];
        int min = 20;
        int zeroCnt = 0;
        //找出最小值和0的个数
        for (int num : numbers) {
            if (num != 0) {
                min = Math.min(num, min);
            } else {
                zeroCnt++;
            }
        }

        //将对应的值填入数组
        for (int num : numbers) {
            if (num != 0) {
                if (num - min > numbers.length - 1 || shun[num - min] == 1) {
                    return false;
                }
                shun[num - min] = 1;
            }
        }
        //将0填入数组
        for (int i : shun) {
            if (i == 0) {
                zeroCnt--;
            }
        }

        return zeroCnt == 0;
    }
}
