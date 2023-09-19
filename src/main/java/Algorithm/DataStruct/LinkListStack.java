package Algorithm.DataStruct;

import javax.lang.model.type.IntersectionType;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-19 17:40
 * @description: leetCode
 */
public class LinkListStack<E>  {
    static class Node<E>{
        E value;
        Node<E> next;
        public Node(E value, Node<E> next){
            this.value=value;
            this.next=next;
        }
    }

    private int capacity;
    private int size;
    private Node<E> head=new Node(null,null);

    public LinkListStack(int capacity){
        this.capacity=capacity;
    }

    public boolean push(E value){
        if (isFull()){
            return false;
        }
       head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    public E pop(){
        if (isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next=first.next;
        return first.value;
    }


    public E peek(){
        if (isEmpty()){
            return null;
        }
        return head.next.value;
    }


    public boolean isEmpty(){
        return head.next==null;
    }
    public boolean isFull(){
        return capacity==size;
    }

}
