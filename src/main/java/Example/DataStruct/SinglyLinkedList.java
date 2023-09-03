package Example.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-07-11 2:12
 * @description: 单向链表
 */
public class SinglyLinkedList {
    private Node head = null;//头指针
    private static class Node {
        int value;//值
        Node next;//下一个结点指针
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头插法
     * @param value
     */
    public void addFirst(int value){
//        //1.链表为空
//        head = new Node(value,null);
        //2.链表非空
        head = new Node(value,head);
    }

    /**
     * 尾插法
     * @param value
     */
    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

    /**
     * 遍历链表
     */
    public void loop(){
        Node p = head;
        while (p!=null){
            System.out.println(p.value);
            p = p.next;
        }
    }

    /**
     * 查找
     * @param index
     * @return
     */
    private Node findNode(int index){
        int i =0;
        for (Node p =head;p!=null;p=p.next,i++){
            if (i==index){
                return p;
            }
        }
        return null;
    }

    public int get(int index){
        Node node = findNode(index);
        if (node==null){
            throw new IllegalArgumentException(
                    String.format("index [%d]不合法",index)
            );
        }
        return node.value;
    }

    /**
     * 插入节点
     * @param index
     * @param value
     */
    public void insert(int index,int value){
        if (index==0){
            addFirst(value);
            return;
        }
        Node prev = findNode(index-1);
        if (prev==null){
            throw new IllegalArgumentException(
                    String.format("index [%d]不合法",index)
            );
        }
        prev.next = new Node(value,prev.next);
    }

    /**
     * 删除的节点
     * @param index
     */
    public void remove(int index){
        if (head==null){
            throw new IllegalArgumentException(
                    String.format("index [%d]不合法",index)
            );
        }
        if (index==0){
            head=head.next;
        }else {
            Node prev = findNode(index-1);
            if (prev != null) {
                Node remove = prev.next;//被删除的节点
                prev.next=remove.next;
            }
        }
    }
}


