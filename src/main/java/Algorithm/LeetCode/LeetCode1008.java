package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-15 20:54
 * @description: leetCode
 */
public class LeetCode1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            int val=preorder[i];
            insert(root,val);
        }
        return root;
    }

    public TreeNode insert(TreeNode node, int val){
        if (node==null){
            return new TreeNode(val);
        }
        if (val<node.val){
            node.left=insert(node.left,val);
        }else if (node.val<val){
            node.right=insert(node.right,val);
        }
        return node;
    }

    /**
     * 分治法
     * @param preorder
     * @return
     */
    //跟654题类似
    public TreeNode bstFromPreorder1(int[] preorder) {
        return partition(preorder,0,preorder.length-1);
    }
    public TreeNode partition(int[] preorder,int start,int end){
        if (start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index=preorder[start+1];
        while (index<=end){
            if (preorder[index]>preorder[start]){
                break;
            }
            index++;
        }
        root.left=partition(preorder, start+1, index-1);
        root.right=partition(preorder,index,end);
        return root;
    }
}
