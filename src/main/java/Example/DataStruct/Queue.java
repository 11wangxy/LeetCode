package Example.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-18 17:02
 * @description: leetCode
 */
public interface Queue<E> {
    boolean offer(E value);
    E poll();
    E peek();
    boolean isEmpty();
    boolean isFull();
}
