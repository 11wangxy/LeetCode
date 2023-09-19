package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-08 0:37
 * @description: leetCode
 */
public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList();
        if(root==null){
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pop=null;//最近的一次弹栈元素
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peek = stack.peek();//栈顶元素
                if (peek.right==null||peek.right==pop){//右子树处理完成
                    pop = stack.pop();
                    result.add(pop.val);
                }else {
                    node=peek.right;
                }
            }
        }
        return result;
    }
}
