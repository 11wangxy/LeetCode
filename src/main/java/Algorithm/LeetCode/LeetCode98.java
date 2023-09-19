package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-15 0:50
 * @description: leetCode
 */
public class LeetCode98 {
    /**
     * 中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        TreeNode node =root;
        Long prev=Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (node!=null||!stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else {
                TreeNode pop = stack.pop();
                if (prev>= pop.val){
                    return false;
                }
                prev = (long) pop.val;
                node=pop.right;
            }
        }
        return true;
    }
}
