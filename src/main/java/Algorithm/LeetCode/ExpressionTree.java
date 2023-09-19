package Algorithm.LeetCode;

import Algorithm.DataStruct.TreeNodeString;

import java.util.Stack;

/**
 * @author: Wang Xiaoyi
 * @date: 2023-09-13 23:51
 * @description: 根据后缀表达式写出二叉树
 */

public class ExpressionTree {
    public TreeNodeString constructExpressionTree(String[] token){
        Stack<TreeNodeString> stack=new Stack<>();
        for (String t:token){
            switch (t){
                case "+","-","*","/"->{
                    TreeNodeString right = stack.pop();
                    TreeNodeString left = stack.pop();
                    TreeNodeString parent = new TreeNodeString(t);
                    parent.left=left;
                    parent.right=right;
                    stack.push(parent);
                }
                default -> {
                    stack.push(new TreeNodeString(t));
                }
            }
        }
        return stack.peek();
    }
}
