package Algorithm.LeetCode;

import java.util.Stack;

class LeetCode232 {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public LeetCode232() {

    }
    
    public void push(int x) {
        s2.push(x);
    }
    
    public int pop() {
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }
    
    public int peek() {
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */