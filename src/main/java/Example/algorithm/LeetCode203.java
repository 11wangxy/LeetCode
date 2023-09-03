package Example.algorithm;

import Example.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-16 11:08
 * @description: leetCode
 */
public class LeetCode203 {

    /**
     * 方法一
     * @param head
     * @param value
     * @return
     */
    public ListNode removeElements(ListNode head, int value){
        ListNode SetinelListNode = new ListNode(-1, head);
        ListNode p1 = SetinelListNode;
        ListNode p2 = p1.next;
        while (p2!=null){
            if (p2.val==value){
                //删除
                p1.next=p2.next;
            }else {
                //p1，p2平移
                p1=p1.next;
            }
            p2=p1.next;
        }
        return SetinelListNode.next;
    }

    /**
     * 方法二：递归
     * @param p
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode p,int val){
        if (p==null){
            return null;
        }
        if (p.val == val){
            return removeElements2(p.next,val);
        }else {
            p.next=removeElements2(p.next,val);
            return p;
        }
    }
}
