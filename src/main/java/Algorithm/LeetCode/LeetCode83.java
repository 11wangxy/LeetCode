package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-17 10:17
 * @description: leetCode
 */
public class LeetCode83 {
    /**
     * method:double pointer
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 节点小于2的情况
        if (head==null||head.next==null){
            return head;
        }
        //节点数大于2
        ListNode p1 = head;
        ListNode p2 ;
        while ((p2=p1.next)!=null){
            if (p1.val == p2.val){
                p1.next=p2.next;
            }else {
                p1=p1.next;
            }
        }
        return head;
    }

    /**
     * method:recursion
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        if (head.val == head.next.val){
            return deleteDuplicates2(head.next);
        }else {
            head.next=deleteDuplicates2(head.next);
            return head;
        }
    }

}
