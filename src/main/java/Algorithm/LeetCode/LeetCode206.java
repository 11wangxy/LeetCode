package Algorithm.LeetCode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-15 21:55
 * @description: leetCode
 */

import Algorithm.DataStruct.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode206 {

    /**
     * 方法一：把旧的链表遍历使用头插法插入新的链表
     * @param o1
     * @return
     */
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;
        ListNode p = o1;
        while (p!=null){
            n1 = new ListNode(p.val, n1);
            p=p.next;
        }
        return n1;
    }

    /**
     * 方法二
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        List list1 = new List(head);
        List list2 = new List(null);
        while (true){
            ListNode first = list1.removeFirst();
            if (first==null){
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

    static class List{
        ListNode head;

        public List(ListNode head){
            this.head=head;
        }

        public void addFirst(ListNode first){
            first.next=head;
            head=first;
        }

        public ListNode removeFirst(){
            ListNode first =head;
            if (first!=null){
                head=first.next;
            }
            return first;
        }
    }

    /**
     * 方法三：递归调用
     * @param p
     * @return
     */
    public ListNode reverseList3(ListNode p){
        if (p==null||p.next==null){
            return p;//得到最后的节点
        }
        ListNode listNode = reverseList3(p.next);
        p.next.next=p;
        p.next=null;
        return listNode;
    }
}
