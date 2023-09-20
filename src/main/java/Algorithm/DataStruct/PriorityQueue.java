package Algorithm.DataStruct;

import java.util.ArrayList;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-20 22:43
 * @description: leetCode
 */
public class PriorityQueue<E extends Comparable<E>> {
    private ArrayList<E> heap;  // 堆数组

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    /**
     * 获取堆中元素的数量
     */
    public int size() {
        return heap.size();
    }

    /**
     * 检查堆是否为空
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * 添加元素到优先级队列中
     */
    public void add(E element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    /**
     * 弹出优先级最高的元素
     */
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        E removedElement = heap.get(0);
        E lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastElement);
            siftDown(0);
        }
        return removedElement;
    }

    /**
     * 进行上移操作
     */
    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    /**
     * 进行下移操作
     */
    private void siftDown(int index) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            siftDown(largestIndex);
        }
    }

    /**
     * 交换数组中两个元素的位置
     */
    private void swap(int index1, int index2) {
        E temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
