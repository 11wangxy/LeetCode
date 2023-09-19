package Algorithm.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-19 23:59
 * @description: leetCode
 */
public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer put = map.put(num, num);
            if (put!=null){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set=new HashSet<>(nums.length*2);
        for (int num : nums) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
