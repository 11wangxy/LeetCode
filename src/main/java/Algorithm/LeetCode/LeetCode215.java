package Algorithm.LeetCode;

import java.util.PriorityQueue;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-31 16:08
 * @description: leetCode
 */

public class LeetCode215 {
    // 创建一个堆
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i]>=heap.peek()){
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }
}
