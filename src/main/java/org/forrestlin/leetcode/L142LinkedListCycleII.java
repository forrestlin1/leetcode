package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 环形链表2
 * @author: forrestlin
 * @create: 2019-10-25 17:26
 */
public class L142LinkedListCycleII {


    //很多题解没有讲清楚非环部分的长度与相遇点到环起点那部分环之间为何是相等的这个数学关系。这里我就补充下为何他们是相等的。
    //假设非环部分的长度是x，从环起点到相遇点的长度是y。环的长度是c。
    //现在走的慢的那个指针走过的长度肯定是x+n1*c+y，走的快的那个指针的速度是走的慢的那个指针速度的两倍。这意味着走的快的那个指针走的长度是2(x+n1*c+y)。
    //
    //还有一个约束就是走的快的那个指针比走的慢的那个指针多走的路程一定是环长度的整数倍。根据上面那个式子可以知道2(x+n1*c+y)-x+n1*c+y=x+n1*c+y=n2*c。
    //
    //所以有x+y=(n2-n1)*c,这意味着什么？我们解读下这个数学公式：非环部分的长度+环起点到相遇点之间的长度就是环的整数倍。这在数据结构上的意义是什么？
    // 现在我们知道两个指针都在离环起点距离是y的那个相遇点，而现在x+y是环长度的整数倍，这意味着他们如果从相遇点再走x就到了起点(从起点到相遇点距离y)。
    //那怎么才能再走x步呢？答：让一个指针从头部开始走，另一个指针从相遇点走，等这两个指针相遇那就走了x步此时就是环的起点。
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            //相遇了，初始化两个指针，一格一个位于开头，一个位于相遇点，再往前走x即到环的起点
            if (fast == slow) {

                ListNode P1 = head;
                ListNode P2 = fast;
                while (P1 != fast) {
                    P1 = P1.next;
                    P2 = P2.next;
                }

                return P1;

            }

        }

        return null;

    }


}
