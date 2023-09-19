package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-16 20:09
 * @description: leetCode
 */
public class LeetCode19 {
    /**
     * 方法一：双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);

        ListNode slow = dummy;
        ListNode fast = dummy;

        // 移动fast指针n+1步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 同时移动slow和fast指针，直到fast到达链表末尾
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 删除slow指针指向的节点
        slow.next = slow.next.next;

        return dummy.next;
    }

    /**
     * 方法二：递归调用
     * @param p
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd2(ListNode p, int n){
        ListNode listNode = new ListNode(0, p);
        recursion(listNode,n);
        return listNode.next;
    }

    private int recursion(ListNode p, int n){
        if (p==null){
            return 0;
        }
        int recursion = recursion(p.next, n);
        if (recursion==n){
            p.next=p.next.next;
        }
        return recursion+1;
    }
}
