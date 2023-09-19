package Algorithm.DataStruct;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-15 21:51
 * @description: leetCode
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val,ListNode next){
        this.next= next;
        this.val=val;
    }
    public ListNode(int val){
        this.val=val;
    }
}
