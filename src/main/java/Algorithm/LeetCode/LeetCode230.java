package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-16 0:59
 * @description: leetCode
 */
public class LeetCode230 {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
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
        Collections.sort(result);
        return result.get(k-1);
    }

    //优化代码，避免遍历全部
    public int kthSmallest1(TreeNode root, int k) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                count++;
                if (count == k) {
                    return pop.val;
                }
                node = pop.right;
            }
        }
        return -1;
    }
}
