package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 平衡二叉树
 * @author: forrestlin
 * @create: 2019-11-18 15:32
 */
public class L39IsBalanced_Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }


    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1; //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;//如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        }
        if (left - right < (-1) || left - right > 1) {
            return -1;
        } else {
            return 1 + (left > right ? left : right);
        }
    }
}


