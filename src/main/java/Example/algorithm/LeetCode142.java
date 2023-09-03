package Example.algorithm;

import Example.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-22 22:44
 * @description: leetCode
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p1=head;
        ListNode p2=head;
        while (p1 != null && p2 != null && p2.next != null){
            p1=p1.next;
            p2=p2.next.next;
            if (p1==p2){
                p1=head;
                while (true){
                    if(p1==p2){
                        return p1;
                    }
                    p1=p1.next;
                    p2=p2.next;
                }
            }
        }
        return null;
    }

}
