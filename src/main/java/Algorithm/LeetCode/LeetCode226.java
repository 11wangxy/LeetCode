package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-02 0:05
 * @description: leetCode
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node==null){
            return;
        }
        TreeNode t=node.left;
        node.left=node.right;
        node.right=t;
        invert(node.left);
        invert(node.right);
    }

}
