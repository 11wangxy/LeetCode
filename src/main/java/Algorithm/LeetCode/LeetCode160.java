package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;
import Algorithm.DataStruct.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-17 22:27
 * @description: leetCode
 */
public class LeetCode160 {
    //方法一
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode currA = headA;
        while (currA != null) {
            visited.add(currA);
            currA = currA.next;
        }

        ListNode currB = headB;
        while (currB != null) {
            if (visited.contains(currB)) {
                return currB;
            }
            currB = currB.next;
        }

        return null;
    }

    //方法二
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA != null) ? pA.next : headB;
            pB = (pB != null) ? pB.next : headA;
        }

        return pA;
    }
}
