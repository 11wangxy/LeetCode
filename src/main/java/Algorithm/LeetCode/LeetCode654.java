package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNode;

import java.util.Arrays;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-16 0:32
 * @description: leetCode
 */
public class LeetCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    // 递归构建最大二叉树
    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end)
            return null;

        // 找到子数组中的最大值作为根节点
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);

        // 递归构建左子树和右子树
        root.left = construct(nums, start, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, end);

        return root;
    }

    // 在子数组中找到最大值的索引
    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

}
