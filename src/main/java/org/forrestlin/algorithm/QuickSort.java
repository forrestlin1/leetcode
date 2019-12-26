package org.forrestlin.algorithm;

/**
 * @program: leetcode
 * @description: 快速排序
 * @author: forrestlin
 * @create: 2019-12-18 19:36
 */
public class QuickSort {

    /**
     *
     *
     * 一趟快速排序的算法是： [1]
     * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1； [1]
     * 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]； [1]
     * 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]的值交换； [1]
     * 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]的值交换； [1]
     * 5）重复第3、4步，直到i=j； (3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。另外，i==j这一过程一定正好是i+或j-完成的时候，此时令循环结束）。 [1]
     *
     * O(nlogn)
     * 当每次选取的pivot为最大值或者最小值的时候，需要递归n次，退化成O(n*n)
     * */
    public static int[] qsort(int arr[], int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = qsort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = qsort(arr, j + 1, end);
        }
        return (arr);
    }
}
