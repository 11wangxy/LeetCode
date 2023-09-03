package Example.algorithm;

class LeetCode26 {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int newIndex = 1; // 指示新数组的位置，初始为 1，因为第一个元素肯定是唯一的
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[newIndex] = nums[i]; // 更新新数组中的唯一元素
                newIndex++;
            }
        }

        return newIndex;

    }
}