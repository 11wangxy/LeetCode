package Example.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-26 19:57
 * @description: leetCode
 */
public class MaxHeap {
    int[] array;
    int size;
    public  MaxHeap(int capacity){
        this.array=new int[capacity];
    }

    private void heapify(){
        for (int i=size/2-1;i>=0;i--){
            down(i);
        }
    }

    private void down(int parent) {
        int left=parent*2+1;
        int right=left+1;
        int max=parent;
        if (left<size&&array[left]>array[max]){
            max=left;
        }
        if (left<size&&array[right]>array[max]){
            max=right;
        }
        if (max!=parent){
            swap(max,parent);
            down(max);
        }
    }

    private void  swap(int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peek(){
        return array[0];
    }

    public int poll(){
        int top=array[0];
        swap(0,size-1);
        size--;
        down(0);
        return top;
    }

    public int poll(int index){
        int deleted=array[index];
        swap(index,size-1);
        size--;
        down(index);
        return deleted;
    }

    public void replace(int replaced){
        array[0]=replaced;
        down(replaced);
    }


}
