package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-22 23:24
 * @description: leetCode
 */
public class LeetCode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
