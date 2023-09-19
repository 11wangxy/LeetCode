package Algorithm.DataStruct;


import java.awt.*;
import java.util.Iterator;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-18 16:48
 * @description: leetCode
 */
public class LinkListQueue<E>  {


    private static class Node<E>{
        E value;
        Node<E> next;
        public Node(E value,Node<E> next){
            this.value=value;
            this.next=next;
        }
    }

    Node<E> head= new Node<>(null,null);
    Node<E> tail=head;
    private int size;
    private int capacity=Integer.MAX_VALUE;
    public LinkListQueue(){
        tail.next=head;
    }

    public LinkListQueue(int capacity){
        this.capacity=capacity;
        tail.next=head;
    }


    public boolean offer(E value) {
        if (isFull()){
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next=added;
        tail=added;
        size++;
        return false;
    }



    public E poll() {
        if (isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next=first.next;
        if (first==tail){
            tail=head;
        }
        size--;
        return first.value;
    }


    public E peek() {
        if (isEmpty()){
            return null;
        }
        return head.next.value;
    }


    public boolean isEmpty() {
        return head == tail;
    }


    public boolean isFull() {
        return size==capacity;
    }
}
