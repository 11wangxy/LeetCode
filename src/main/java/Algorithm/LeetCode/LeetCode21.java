package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;


/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-18 16:04
 * @description: leetCode
 */
public class LeetCode21 {
    /**
     * first method:creat a new linkList
     * @param p1
     * @param p2
     * @return
     */
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(0, null);
        ListNode p3=s;
        while (p1!=null&&p2!=null){
            if(p1.val< p2.val){
                p3.next=p1;
                p1=p1.next;
            }else {
                p3.next=p2;
                p2=p2.next;
            }
            p3=p3.next;
        }
        if (p1==null){
            p3.next=p2;
        }
        if (p2==null){
            p3.next=p1;
        }
        return s.next;
    }

    /**
     * second method: recursion
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list2==null){
            return list1;
        }
        if(list1==null){
            return list2;
        }
        if (list1.val<list2.val){
            list1.next=mergeTwoLists2(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoLists2(list1.next,list1);
            return list2;
        }
    }
}
