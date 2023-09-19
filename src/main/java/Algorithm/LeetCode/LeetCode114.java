package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.*;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-14 1:07
 * @description: leetCode
 * <p>
 * TODO
 */
public class LeetCode114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                if (prev != null) {
                    prev.right = node;
                }
                prev = node;
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
            }
        }
        TreeNode curr = root;
        while (curr != null) {
            curr.left = null;
            curr = curr.right;
        }
    }



}
