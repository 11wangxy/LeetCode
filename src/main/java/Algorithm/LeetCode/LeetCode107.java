package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-17 2:00
 * @description: leetCode
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result= new LinkedList<>();
        if (root==null){
            return result;
        }
        LinkedList<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        int c1=1; //每层有几个元素
        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int c2=0;
            for (int i = 0; i < c1; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left!=null){
                    queue.offer(poll.left);
                    c2++;
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                    c2++;
                }
            }
            result.add(0,level);
            c1=c2;
        }
        return result;
    }
}
