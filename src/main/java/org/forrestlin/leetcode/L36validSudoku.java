package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 有效的数独
 * @author: forrestlin
 * @create: 2019-11-28 16:32
 */
public class L36validSudoku {

    /**
     * 空间换时间，一次遍历，同时使用三个map数组记录以及遍历的数在所在的行、列、box中
     */
    public boolean isValidSudoku(char[][] board) {
        // init data
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];
        //
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    //TODO box的计算值得关注
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    /*
     * 相同的思想，不过上面解法使用了hash表来存储，下面是用位来存储
     * */
    public boolean isValidSudoku2(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] sub = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //当前字符是'.'则跳过, 直接进入下一轮循环
                if (board[i][j] == '.') {
                    continue;
                }
                //处理行
                if (!valid(row, i, board[i][j] - 48)) {
                    return false;
                }
                //处理列
                if (!valid(col, j, board[i][j] - 48)) {
                    return false;
                }
                //处理子数独
                int index = i / 3 * 3 + j / 3;
                if (!valid(sub, index, board[i][j] - 48)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean valid(int[] arr, int i, int cur) {
        //cur出现过, 返回false
        if (((arr[i] >> cur) & 1) == 1) {
            return false;
        }
        //cur没出现过, 标记为出现过
        arr[i] = arr[i] | (1 << cur);
        return true;
    }


}
