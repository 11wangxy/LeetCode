import Example.algorithm.LeetCode35;

import java.util.Arrays;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-07-11 1:49
 * @description: leetCode
 */
public class test34 {
    public static void main(String[] args) {
        LeetCode35 leetCode34 = new LeetCode35();
        int[] list = new int[]{5,7,7,8,8,10};
        int[] ints = leetCode34.searchRange(list, 6);
        System.out.println(Arrays.toString(ints));
    }
}
