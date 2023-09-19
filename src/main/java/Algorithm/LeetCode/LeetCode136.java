package Algorithm.LeetCode;

import java.util.HashSet;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-20 0:06
 * @description: leetCode
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add){
                set.remove(num);
            }
        }
        return set.toArray(new Integer[0])[0];
    }

    //使用异或优化
    public int singleNumber1(int[] nums) {
        int num=nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
