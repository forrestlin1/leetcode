package org.forrestlin.leetcode2;

/*
 * 寻找重复数字
 * */
public class L287FindTheDuplicateNumber {

    //方法1，Arrays.sort后遍历  方法2，遍历时使用hashset存储
    //方法3如下
    //使用数组中的值作为索引下标进行遍历，遍历的结果肯定是一个环（有一个重复元素）
    //那么这个问题就转换为求环的入口了，可以参考142题，求环形链表的入口
    public int findDuplicate(int[] nums) {
        //找到相遇点
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //让finder从起点出发，finder和slow相遇的地方就是环的入口，也就是重复数字
        int finder = nums[0];
        while (finder != slow) {
            finder = nums[finder];
            slow = nums[slow];
        }

        return finder;

    }

}
