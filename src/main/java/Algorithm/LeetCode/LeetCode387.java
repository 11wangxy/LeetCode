package Algorithm.LeetCode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-20 0:22
 * @description: leetCode
 */
public class LeetCode387 {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            arr[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
