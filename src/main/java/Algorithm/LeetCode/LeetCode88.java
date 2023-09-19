package Algorithm.LeetCode;

import java.util.Arrays;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-22 23:08
 * @description: leetCode
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
