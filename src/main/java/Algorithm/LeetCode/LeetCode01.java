package Algorithm.LeetCode;

import java.util.HashMap;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-16 11:13
 * @description: leetCode
 */
public class LeetCode01 {
    //穷举遍历
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //哈希表
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x=nums[i];
            int y= target-x;
            if (map.containsKey(y)){
                return new int[]{i,map.get(y)};
            }else {
                map.put(x,i);
            }
        }
        return null;
    }
}
