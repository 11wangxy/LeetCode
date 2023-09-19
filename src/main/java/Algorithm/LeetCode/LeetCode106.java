package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.Arrays;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-14 0:50
 * @description: leetCode
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i]==root.val){
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                root.left=buildTree(inLeft,postLeft);
                root.right=buildTree(inRight,postRight);
                break;
            }
        }
        return root;
    }
}
