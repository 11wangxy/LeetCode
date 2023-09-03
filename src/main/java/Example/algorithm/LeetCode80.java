package Example.algorithm;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-29 17:03
 * @description: leetCode
 */
public class LeetCode80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 2] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
