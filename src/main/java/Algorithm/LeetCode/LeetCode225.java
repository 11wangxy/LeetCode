package Algorithm.LeetCode;

import java.util.LinkedList;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-19 20:27
 * @description: leetCode
 */
public class LeetCode225 {
    LinkedList<Integer> queue = new LinkedList<>();
    private int size=0;
    public LeetCode225() {

    }

    public void push(int x) {
        queue.offer(x);
        for (int i=0;i<size;i++){
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
