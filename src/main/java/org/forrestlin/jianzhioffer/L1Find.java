package org.forrestlin.jianzhioffer;

/*
 * 二维树组中的查找
 * */
public class L1Find {

    /*
     * 从左下往右上找
     * */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int x = array.length - 1;
        int y = 0;

        while (y < array[0].length && x >= 0) {
            if (array[x][y] < target) {
                y++;
            } else if (array[x][y] > target) {
                x--;
            } else {
                return true;
            }

        }
        return false;

    }
}
