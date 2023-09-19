package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-30 0:52
 * @description: leetCode
 */
public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
