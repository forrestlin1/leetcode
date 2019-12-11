package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 将有序数组转换为二叉搜索树
 * @author: forrestlin
 * @create: 2019-12-10 11:41
 */
public class L108convertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || 0 == nums.length) {
            return null;
        }
        return toTree(nums, 0, nums.length - 1);
    }

    private TreeNode toTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }
        int mid = begin + ((end - begin) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = toTree(nums, begin, mid - 1);
        TreeNode right = toTree(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;

    }
}
