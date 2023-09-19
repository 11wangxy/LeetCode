package Algorithm.LeetCode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-19 0:55
 * @description: leetCode
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
