package Example.algorithm;

import Example.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-02 0:05
 * @description: leetCode
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        return invert(root);
    }

    public TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

}
