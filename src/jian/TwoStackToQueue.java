package jian;

import java.util.Stack;

public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()) {
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        TwoStackToQueue t = new TwoStackToQueue();
        t.push(1);
        t.push(2);
        t.push(3);
        System.out.println(t.pop());
        t.push(4);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());

    }
}
