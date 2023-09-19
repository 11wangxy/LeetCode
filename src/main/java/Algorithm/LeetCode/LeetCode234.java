package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-21 1:20
 * @description: leetCode
 */
public class LeetCode234 {

    /**
     * method: reverseLinkedList
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;

            // 找到链表的中间节点
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 反转后半部分链表
            ListNode secondHalf = reverseLinkedList(slow);

            // 比较前半部分和反转后的后半部分是否相等
            ListNode p1 = head;
            ListNode p2 = secondHalf;
            while (p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            return true;
        }

        private ListNode reverseLinkedList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }


    /**
     * method:use stack
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        ListNode s = p;
        int i = 0;
        while (p != null) {
            p = p.next;
            i++;
        }
        if (i == 1 || i == 0) {
            return true;
        }
        if (i % 2 == 0) {
            for (int n = 0; n < i; n++) {
                if (n < (i >> 1)) {
                    stack.push(s.val);
                    s = s.next;
                } else {
                    if (s.val == stack.peek()) {
                        stack.pop();
                        s = s.next;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            for (int n = 0; n < i; n++) {
                if (n < (i >> 1)) {
                    stack.push(s.val);
                    s = s.next;
                } else if (n > (i >> 1)) {
                    if (s.val == stack.peek()) {
                        stack.pop();
                        s = s.next;
                    } else {
                        return false;
                    }
                } else {
                    s = s.next;
                }
            }
        }
        return true;
    }
}
