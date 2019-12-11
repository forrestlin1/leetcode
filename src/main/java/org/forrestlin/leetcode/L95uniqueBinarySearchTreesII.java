package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 不同的二叉搜索树II
 * @author: forrestlin
 * @create: 2019-12-09 15:52
 */
public class L95uniqueBinarySearchTreesII {

    /**
     * 递归，在递归中分别构建左子树和
     * */
    public List<TreeNode> generateTrees(int n) {
        if (n >= 1) {
            return doGenerate(1, n);
        } else {
            return new ArrayList<>();
        }
    }

    private List<TreeNode> doGenerate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = doGenerate(start, i - 1);
            List<TreeNode> right = doGenerate(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);

                }
            }
        }
        return res;


    }

}
