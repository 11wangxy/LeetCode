package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-08 0:19
 * @description: leetCode
 */
public class LeetCode144 {

    /**
     * method1：递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = preOrder(root);
        return integers;
    }

    public List<Integer> preOrder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        result.add(node.val);
        result.addAll(preOrder(node.left));
        result.addAll(preOrder(node.right));
        return result;
    }

    /**
     * 方法二：迭代
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                node = pop.right;
            }
        }
        return result;
    }
}
