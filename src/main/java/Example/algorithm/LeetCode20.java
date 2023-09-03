package Example.algorithm;

import Example.DataStruct.LinkListStack;

import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-08-19 17:57
 * @description: leetCode
 */
public class LeetCode20 {

    public boolean isValid(String s) {
//        LinkListStack<Character> stack = new LinkListStack<>(s.length());
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='('){
                stack.push(')');
            } else if (c=='[') {
                stack.push(']');
            } else if (c=='{') {
                stack.push('}');
            }else {
                if (!stack.isEmpty()&&c==stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
