package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-15 21:20
 * @description: leetCode
 */
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node=root;
        while (p.val<node.val&&q.val< node.val||p.val>node.val&&q.val> node.val){//在同一侧
            if (p.val<node.val){
                node=node.left;
            }else {
                node=node.right;
            }
        }
        return node;
    }
}
