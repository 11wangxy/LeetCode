package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;
import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-17 22:03
 * @description: leetCode
 */
public class LeetCode109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        // 使用快慢指针找到中间节点
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 以中间节点的值创建根节点
        TreeNode root = new TreeNode(slow.val);
        // 递归构建左子树和右子树
        root.left = buildBST(start, slow);
        root.right = buildBST(slow.next, end);
        return root;
    }
}
