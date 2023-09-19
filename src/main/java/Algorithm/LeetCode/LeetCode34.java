package Algorithm.LeetCode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-16 11:11
 * @description: leetCode
 */
public class LeetCode34 {
    public int searchInsert(int[] a, int target) {
        int i = 0;
        int j = a.length-1;
        while(i<=j){
            int m = (i+j)>>>1;
            if(target<=a[m]){
                j=m-1;
            }else {
                i=m+1;
            }
        }
        return i;
    }
}
