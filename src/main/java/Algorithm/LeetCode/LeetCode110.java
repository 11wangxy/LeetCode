package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-17 2:15
 * @description: leetCode
 */
public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        TreeNode node=root;
        // 递归检查每个子树是否是高度平衡的
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getHeight(TreeNode node) {
        if (node==null){
            return 0;
        }
        // 递归计算左子树和右子树的高度，取最大值加1作为当前节点的高度
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Integer.max(leftHeight, rightHeight) + 1;
    }
}
