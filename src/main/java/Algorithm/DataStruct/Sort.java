package Algorithm.DataStruct;

import javax.sound.midi.Soundbank;
import java.beans.beancontext.BeanContext;
import java.util.Arrays;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-19 23:01
 * @description: leetCode
 */
public class Sort {
    // 冒泡排序
    // 数组a 未排序右边边界
    public static void bubbleSort(int[] a) {
        int j = a.length - 1;
        do {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    x = i;
                }
            }
            j = x;
        } while (j != 0);
    }

    //选择排序
    public static void selectSort(int[] a){
        //1.选择轮数 a.length-1
        //2.交换索引的位置 初始a.length-1 每次递减
        for (int right = a.length-1; right >0; right--) {
            int max=right;
            for (int i = 0; i < right; i++) {
                if (a[i]>a[max]){
                    max=i;
                }
            }
            if (max!=right){
                int t = a[max];
                a[max] = a[right];
                a[right] = t;
            }
        }
    }

    public static void

    public static void main(String[] args) {
        int[] a={6,5,4,3,2,1,0,-3,-12};
        System.out.println(Arrays.toString(a));
//        bubbleSort(a);
//        System.out.println(Arrays.toString(a));
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
