package Algorithm.LeetCode;

import java.util.Arrays;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-20 0:16
 * @description: leetCode
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(getKey(s),getKey(t));
    }

    private int[] getKey(String s){
        int[] arr= new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c-97]++;
        }
        return arr;
    }

    //优化
    private int[] getKey1(String s){
        int[] arr= new int[26];
        char[] chars = s.toCharArray();
        for (char ch:chars) {
            arr[ch-97]++;
        }
        return arr;
    }
}
