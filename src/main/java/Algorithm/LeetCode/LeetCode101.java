package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-02 0:06
 * @description: leetCode
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null || l.val != r.val) {
            return false;
        }
        return isSame(l.left, r.right) && isSame(l.right, r.left);
    }

}
