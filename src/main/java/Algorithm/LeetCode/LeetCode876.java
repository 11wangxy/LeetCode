package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-20 19:49
 * @description: leetCode
 */
public class LeetCode876 {
    /**
     * method:loop to get size
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode p=head;
        int i =0;
        while (p!=null){
            p=p.next;
            i++;
        }
        int m=i>>>1;
        for (int n =0;n<m;n++){
            head=head.next;
        }
        return head;
    }

    /**
     * method:fast and slow pointer
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
