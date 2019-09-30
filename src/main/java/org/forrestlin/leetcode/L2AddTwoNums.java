package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 两数相加
 * @author: forrestlin
 * @create: 2019-09-10 14:46
 *
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2AddTwoNums {

    public static void main(String[] args) {
        long a = Long.valueOf("399999999");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        //l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(0);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位
        int ch = 0;

        ListNode lh = new ListNode(0);
        ListNode lp = lh;
        while (l1 != null || l2 != null) {

            int c1 = (l1 != null) ? l1.val : 0;

            int c2 = (l2 != null) ? l2.val : 0;

            int cur = c1 + c2 + ch;

            if (cur >= 10) {
                lp.next = new ListNode(cur - 10);

                ch = 1;
            } else {
                lp.next = new ListNode(cur);
                ch = 0;
            }

            lp = lp.next;

            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;

        }

        if (ch > 0) {
            lp.next = new ListNode(ch);
        }

        return lh.next;
    }
}