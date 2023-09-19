package Algorithm.LeetCode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-07-11 1:32
 * @description: 二分查找 34题
 */
public class LeetCode35 {

    public int[] searchRange(int[] nums, int target) {
        int left = left(nums, target);
        if (left==-1){
            return new int[]{-1,-1};
        }else {
            int right = right(nums, target);
            return new int[]{left,right};
        }
    }

    public int left(int[] a, int target){
        int i = 0;
        int j = a.length-1;
        int candidate= -1;
        while (i<=j){
            int m = (i+j)>>>1;
            if (target < a[m]){
                j=m-1;
            }else if (target>a[m]){
                i=m+1;
            }else {
                candidate = m;
                j=m-1;
            }
        }
        return candidate;
    }

    public int right(int a[], int target){
        int i = 0;
        int j = a.length-1;
        int candidate= -1;
        while (i<=j){
            int m = (i+j)>>>1;
            if (target < a[m]){
                j=m-1;
            }else if (target>a[m]){
                i=m+1;
            }else {
                candidate = m;
                i=m+1;
            }
        }
        return candidate;
    }
}