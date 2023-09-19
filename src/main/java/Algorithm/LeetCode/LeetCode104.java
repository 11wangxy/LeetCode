package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-08 0:17
 * @description: leetCode
 */
public class LeetCode104 {
    /**
     * 递归
     * 深度优先
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int i = maxDepth(root.left);
        int j = maxDepth(root.right);
        return Integer.max(i, j) + 1;
    }

    /**
     * 使用栈
     * 深度优先搜索
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        TreeNode curr = root;
        TreeNode pop = null;
        Stack<TreeNode> stack = new Stack<>();
        int max = 0;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }

    /**
     * 层序遍历
     * 广度优先搜索
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth =0;
//        int c1 = 1;//记录每层有几个元素
        while (!queue.isEmpty()) {
//            int c2=0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
//                    c2++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
//                    c2++;
                }
            }
//            c1=c2;
            depth++;
        }
        return depth;
    }
}
