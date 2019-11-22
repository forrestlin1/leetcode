package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 二叉树的下一个节点
 * @author: forrestlin
 * @create: 2019-11-21 11:02
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class L57GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //由于是中序遍历，有右节点，找到右节点的第一个需要访问的节点，即为下一个需要访问的节点
        if (pNode.right != null) {
            return downTrace(pNode.right);
        }
        //由于是中序遍历，有父节点，找出往上遍历，下一个需要访问的节点
        if (pNode.next != null) {
            return upTrace(pNode.next, pNode);
        }
        return null;

    }

    private TreeLinkNode upTrace(TreeLinkNode f, TreeLinkNode child) {
        //这里需要区分下自己是父节点的左孩子还是右孩子
        if (f.left == child) {
            return f;
        } else {
            if (f.next == null) {
                return null;
            }
            return upTrace(f.next, f);
        }
    }

    private TreeLinkNode downTrace(TreeLinkNode h) {
        if (h.left != null) {
            return downTrace(h.left);
        } else {
            return h;
        }

    }
}
