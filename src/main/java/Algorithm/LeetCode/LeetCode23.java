package Algorithm.LeetCode;

import Algorithm.DataStruct.ListNode;
import Algorithm.DataStruct.MinHeap;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-18 16:32
 * @description: leetCode
 */
public class LeetCode23 {

    /**
     * method1
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        return split(lists,0,lists.length-1);
    }

    private ListNode split(ListNode[] lists,int i,int j){
        if (i==j){
            //此时数组内只有一个链表
            return lists[i];
        }
        int m=(i+j)>>>1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(0, null);
        ListNode p3=s;
        while (p1!=null&&p2!=null){
            if(p1.val< p2.val){
                p3.next=p1;
                p1=p1.next;
            }else {
                p3.next=p2;
                p2=p2.next;
            }
            p3=p3.next;
        }
        if (p1==null){
            p3.next=p2;
        }
        if (p2==null){
            p3.next=p1;
        }
        return s.next;
    }

    //使用优先级队列，小顶堆
    public ListNode mergeKLists1(ListNode[] lists) {
        MinHeap heap=new MinHeap(lists.length);
        //1.把链表的头结点加入到小顶堆
        for (ListNode list : lists) {
            if (list!=null){
                heap.offer(list);
            }
        }
        //2.不断从堆顶元素移除最小元素，加入新链表
        ListNode s=new ListNode(-1,null);
        ListNode t=s;
        while (!heap.empty()){
            ListNode min = heap.poll();
            t.next=min;
            t=min;
            if (min.next!=null){
                heap.offer(min.next);
            }
        }
        return s.next;
    }
}
