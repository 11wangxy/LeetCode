package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-17 1:46
 * @description: leetCode
 */
public class LeetCode99 {
    //迭代
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode prevNode = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                if (prevNode != null && prevNode.val > pop.val) {
                    if (firstNode == null) {
                        firstNode = prevNode; // 第一对顺序错误的节点
                    }
                    secondNode = pop; // 第二对顺序错误的节点
                }
                prevNode = pop;
                node = pop.right;
            }
        }
        // 交换两个节点的值
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    //递归
    class Solution {
        TreeNode a = null, b = null, last = null;
        public void recoverTree(TreeNode root) {
            dfs(root);
            int val = a.val;
            a.val = b.val;
            b.val = val;
        }
        void dfs(TreeNode root) {
            if (root == null) return ;
            dfs(root.left);
            if (last != null && last.val > root.val) {
                if (a == null) {
                    a = last; b = root;
                } else {
                    b = root;
                }
            }
            last = root;
            dfs(root.right);
        }
    }

}
