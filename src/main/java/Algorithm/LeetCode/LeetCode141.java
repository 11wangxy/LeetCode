package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-22 22:43
 * @description: leetCode
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode p1=head;
        ListNode p2=head;
        while (p1 != null && p2 != null && p2.next != null){
            p1=p1.next;
            p2=p2.next.next;
            if (p1==p2){
                return true;
            }
        }
        return false;
    }
}
