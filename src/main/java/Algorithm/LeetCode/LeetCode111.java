package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-08 0:49
 * @description: leetCode
 */
public class LeetCode111 {

    /**
     * 递归
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int i = minDepth(root.left);
        int j = minDepth(root.right);
        if (i==0){
            return j+1;
        }
        if (j==0){
            return i+1;
        }
        return Integer.min(i,j)+1;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth =0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left==null&&poll.right==null){
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
