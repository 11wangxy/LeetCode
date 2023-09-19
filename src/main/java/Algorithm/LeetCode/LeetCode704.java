package Algorithm.LeetCode;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-16 11:13
 * @description: leetCode
 */
public class LeetCode704 {
    public int search(int[] a, int target) {
        int i = 0;
        int j = a.length;
        while(1<j-i){
            int m = (i+j)>>>1;
            if(target< a[m]){
                j = m;
            }else{
                i = m;
            }
        }
        return (a[i]==target)? i : -1;
    }
}
