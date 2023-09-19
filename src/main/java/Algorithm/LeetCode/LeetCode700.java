package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-15 0:35
 * @description: leetCode
 */
public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (val < node.val) {
                node = node.left;
            } else if (val > node.val) {
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }

    /**
     * recursion
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (val< root.val){
            return searchBST1(root.left,val);
        }else if (val> root.val){
            return searchBST1(root.right,val);
        }else return root;
    }
}
