package Algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-31 15:05
 * @description: leetCode
 */
public class LeetCode118 {


    List<List<Integer>> list = new ArrayList<>();

    private int element(int[][] triangle, int i, int j) {
        if (triangle[i][j] > 0) {
            return triangle[i][j];
        }
        if (j == 0 || i == j) {
            triangle[i][j] = 1;
            return 1;
        }
        triangle[i][j] = element(triangle, i - 1, j - 1) + element(triangle, i - 1, j);
        return triangle[i][j];
    }

    public List<List<Integer>> generate(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) { // row
            triangle[i] = new int[i + 1];
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list1.add(element(triangle, i, j));
            }
            list.add(list1);
        }
        return list;
    }

    /**
     * 使用一维数组
     */
    private void createRow(int [] row,int i){
        if (i==0){
            row[0]=1;
            return ;
        }
        for (int j = i; j >0 ; j--) {
            row[j]=row[j]+row[j-1];
        }
    }

    public List<List<Integer>> generate1(int n) {
        int[] row=new int[n];
        for (int i = 0; i < n; i++) { // row
            createRow(row,i);
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list1.add(row[j]);
            }
            list.add(list1);
        }
        return list;
    }
}
