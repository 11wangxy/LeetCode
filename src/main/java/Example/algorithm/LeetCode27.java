package Example.algorithm;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-01 1:27
 * @description: leetCode
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
