package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-15 20:36
 * @description: leetCode
 */
public class LeetCode938 {
    /**
     * 中序遍历
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST1(TreeNode root, int low, int high) {
        TreeNode node=root;
        Stack<TreeNode> stack = new Stack<>();
        int sum=0;
        while (node!=null||!stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else {
                TreeNode pop = stack.pop();
                if (pop.val>high){
                    break;
                }
                if (pop.val>=low){
                    sum+=pop.val;
                }
                node=pop.right;
            }
        }
        return sum;
    }

    /***
     * 上下限递归
     * @param node
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null){
            return 0;
        }
        if (node.val<low){
            return rangeSumBST(node.right,low,high);
        }
        if (node.val>high){
            return rangeSumBST(node.left,low,high);
        }
        //在范围内
        return node.val+rangeSumBST(node.left,low,high)+rangeSumBST(node.right,low,high);
    }
}
