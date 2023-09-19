package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-15 0:05
 * @description: leetCode
 */
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode parent = null;

        while (node != null) {
            parent = node;
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            } else if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            }
        }

        if (parent == null) {
            root = new TreeNode(val);
        } else if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }
}
