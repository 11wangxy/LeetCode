package Example.algorithm;


import Example.DataStruct.LinkListQueue;
import Example.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-18 22:46
 * @description: leetCode
 */
public class LeetCode102 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root==null){
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();

//            LinkListQueue<TreeNode> queue = new LinkListQueue<>();
            queue.offer(root);
            int c1=1;//当前层节点数
            while (!queue.isEmpty()){
                ArrayList<Integer> level = new ArrayList<>();
                int c2=0;
                for (int i=0;i<c1;i++){
                    TreeNode n = queue.poll();
                    level.add(n.val); // 添加节点值到当前层列表
                    if (n.left!=null){
                        queue.offer(n.left);
                        c2++;
                    }
                    if (n.right!=null){
                        queue.offer(n.right);
                        c2++;
                    }
                }
                result.add(level);
                c1=c2;
            }
            return result;
        }
}
