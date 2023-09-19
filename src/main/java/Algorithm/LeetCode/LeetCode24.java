package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-17 21:26
 * @description: leetCode
 */
public class LeetCode24 {

    public ListNode swapPairs1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode prev=new ListNode(0,head);
        ListNode dummy=prev;
        while (prev.next!=null&&prev.next.next!=null){
            ListNode first=prev.next;
            ListNode second=first.next;

            first.next=second.next;
            second.next=first;
            prev.next=second;

            prev=first;
        }
        return dummy.next;
    }

    //递归实现
    public ListNode swapPairs(ListNode head) {
        // 递归终止条件：剩余节点不足2个，或没有节点
        if (head == null || head.next == null) {
            return head;
        }

        // 交换当前两个节点
        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        // 返回交换后的第一个节点（即原来的第二个节点，现在成为头节点）
        return second;
    }

}
