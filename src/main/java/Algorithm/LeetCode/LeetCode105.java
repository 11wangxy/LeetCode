package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.Arrays;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-14 0:04
 * @description: leetCode
 */
public class LeetCode105 {

    /**
     * 1
     * /   \
     * 2   3
     * /   / \
     * 4   6 7
     * preOrder=1 2 4 3 6 7
     * inOrder= 4 2 1 6 3 7
     * 根1
     * pre     in
     * 左  2,4     4,2
     * 右 3,6,7    6,3,7
     * <p>
     * 根2
     * 左  4
     * <p>
     * 根3
     * 左  6
     * 右  7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //创建根节点
        TreeNode root = new TreeNode(preorder[0]);
        //区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                //0~i-1 左子树
                //i+1~inorder.length-1 右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, inorder.length);

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }

}
