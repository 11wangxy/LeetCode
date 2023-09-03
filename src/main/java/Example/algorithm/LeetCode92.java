package Example.algorithm;

import Example.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-22 23:21
 * @description: leetCode
 */
public class LeetCode92 {
    /**
     * method1
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0,null);
        dummy.next = head;
        ListNode prev = dummy;

        // 找到要反转的前一个节点 prev
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        // 将[curr, next]这段节点进行反转
        for (int i = left; i < right; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    /**
     * method2
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode newHead = null;
        ListNode newTail = null;
        ListNode curr = head;
        int count = 1;

        // 将 left 前面的节点连接到新链表
        while (count < left) {
            if (newHead == null) {
                newHead = head;
                newTail = head;
            } else {
                newTail.next = curr;
                newTail = newTail.next;
            }
            curr = curr.next;
            count++;
        }

        // 对 left 到 right 范围内的节点进行头插法生成新的链表
        ListNode reversedHead = null;
        while (count <= right) {
            ListNode next = curr.next;
            curr.next = reversedHead;
            reversedHead = curr;
            curr = next;
            count++;
        }

        // 将新的链表连接到原链表
        if (newHead == null) {
            head = reversedHead;
        } else {
            newTail.next = reversedHead;
        }

        // 将剩余的节点连接上
        while (reversedHead.next != null) {
            reversedHead = reversedHead.next;
        }
        reversedHead.next = curr;

        return head;
    }
}
