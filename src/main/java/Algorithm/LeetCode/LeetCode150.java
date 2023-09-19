package Algorithm.LeetCode;

import com.sun.source.tree.IfTree;

import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-19 19:40
 * @description: leetCode
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        String[] s = new String[]{"+", "-", "*", "/"};
        for (String token:tokens){
            switch (token){
                case "+"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a+b);
                }
                case "-"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b-a);
                }
                case "*"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(a*b);
                }
                case "/"->{
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b/a);
                }
                default->{//数字则入栈
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }

}
