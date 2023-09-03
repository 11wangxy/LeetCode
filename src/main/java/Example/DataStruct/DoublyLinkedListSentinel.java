package Example.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-15 9:36
 * @description:带哨兵的双向链表
 */
public class DoublyLinkedListSentinel {

    static class Node{
        Node prev;
        int value;
        Node next;
        public Node(Node prev,int value,Node next){
            this.prev=prev;
            this.value=value;
            this.next=next;
        }
    }
    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel(){
        head = new Node(null,666,null);
        tail =new Node(null,888,null);
        head.next=tail;
        tail.prev=head;
    }

    /**
     * 查找
     * @param index
     * @return
     */
    private Node findNode(int index){
        int i = -1;
        for (Node p =head;p!=tail;p=p.next,i++){
            if (i==index){
                return p;
            }
        }
        return null;
    }

    /**
     * 根据索引插入
     * @param index
     * @param value
     */
    public void insert(int index,int value){
        Node prev = findNode(index - 1);
        Node next = prev.next;
        Node node = new Node(prev, value, next);
        prev.next=node;
        next.prev=node;
    }

    /**
     * 根据索引删除
     * @param index
     */
    public void remove(int index){
        Node prev = findNode(index - 1);
        Node node = prev.next;
        prev.next=node.next;
        node.next.prev=prev;
    }

    public void addLast(int value){
        Node last = tail.prev;
        Node node = new Node(last, value, tail);
        last.next=node;
        tail.prev=node;
    }

    public void addFirst(int value){
        Node first = head.next;
        Node node = new Node(head, value, first);
        head.next=node;
        first.prev=node;
    }

}
