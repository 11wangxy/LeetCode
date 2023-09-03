package Example.algorithm;

import java.util.LinkedList;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-15 17:31
 * @description: 汉诺塔问题
 */
public class Hanoi {
    static LinkedList<Integer> a= new LinkedList<>();
    static LinkedList<Integer> b= new LinkedList<>();
    static LinkedList<Integer> c= new LinkedList<>();

    static void init(int n){
        for (int i=n;i>=1;i--){
            a.addLast(i);
        }
    }

    static void move(int n,LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c){
        if (n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        move(n-1,b,c,a);
    }

    public static void main(String[] args) {
        init(3);
        print();
        b.addLast(a.removeLast());
        System.out.println("---------------");
       print();
    }

    private static void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
