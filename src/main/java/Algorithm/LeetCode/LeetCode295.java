package Algorithm.LeetCode;

import Algorithm.DataStruct.MaxHeap;
import Algorithm.DataStruct.MinHeap;

import java.util.PriorityQueue;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-17 21:44
 * @description: leetCode
 */
public class LeetCode295 {

    public static class MedianFinder {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            // 初始化小顶堆和大顶堆
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a); // 使用Lambda表达式创建大顶堆
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            // 平衡两个堆的大小
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }
}
