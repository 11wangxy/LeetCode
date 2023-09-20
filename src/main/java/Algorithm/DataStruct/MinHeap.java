package Algorithm.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-20 23:15
 * @description: leetCode
 */
public class MinHeap {
    ListNode[] array;
    int size;

    public MinHeap(int capacity){
        array=new ListNode[capacity];
    }

    public boolean offer(ListNode offer){
        if (full()){
            return false;
        }
        int child=size++;
        int parent=(child-1)/2;
        while (child>0&&offer.val<array[parent].val){
            array[child]=array[parent];
            child=parent;
            parent=(child-1)/2;
        }
        array[child]=offer;
        return true;
    }

    //首先交换堆顶元素和尾部元素，然后删除
    public ListNode poll(){
        if (empty()){
            return null;
        }
        swap(0,size-1);
        size--;
        ListNode e= array[size];
        array[size]=null;
        down(0);
        return e;
    }

    private void down(int parent){
        int left=2*parent+1;
        int right=left+1;
        int min=parent;
        if (left<size&&array[left].val<array[parent].val){
            min=left;
        }
        if ((right<size)&&array[right].val<array[parent].val){
            min =right;
        }
        if (min!=parent){
            swap(min,parent);
            down(min);
        }
    }

    private void swap(int i,int j){
        ListNode t=array[i];
        array[i]=array[j];
        array[j]=t;
    }

    public boolean empty(){
        return size==0;
    }
    public boolean full(){
        return size==array.length;
    }
}
