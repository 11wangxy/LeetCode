package Algorithm.LeetCode;

import java.util.PriorityQueue;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-05 0:47
 * @description: leetCode
 */
public class LeetCode703 {
    // 创建一个小顶堆
    PriorityQueue<Integer> minHeap;
    int heapSize;
    public LeetCode703(int k, int[] nums) {
        heapSize = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < heapSize) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
