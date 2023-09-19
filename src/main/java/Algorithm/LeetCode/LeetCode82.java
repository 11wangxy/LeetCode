package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-17 10:57
 * @description: leetCode
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode s=new ListNode(0,head);
        ListNode p1=s;
        ListNode p2,p3;
        while ((p2=p1.next)!=null&&(p3=p2.next)!=null){
            if (p2.val==p3.val){
                while ((p3=p3.next)!=null&&p3.val==p2.val){
                }
                //p3已经找到了不重复的值
                p1.next=p3;
            }else {
                p1=p1.next;
            }
        }
        return s.next;
    }

    /**
     * method:recursion
     * @param p
     * @return
     */
    public ListNode deleteDuplicates2(ListNode p){
        if (p==null||p.next==null){
            return p;
        }
        if (p.val==p.next.val){
            ListNode x= p.next.next;
            while (x!=null&&x.val==p.val){
                x=x.next;
            }
            return deleteDuplicates2(x);
        }else {
        p.next=deleteDuplicates2(p.next);
        return p;
        }
    }
}
