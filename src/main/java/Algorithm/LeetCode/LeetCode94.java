package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-08 0:32
 * @description: leetCode
 */
public class LeetCode94 {
    /**
     * 方法一：递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList();
        if(root==null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                node = pop.right;
            }
        }
        return result;
    }
}
