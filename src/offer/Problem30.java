package offer;

import java.util.Stack;

public class Problem30 {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> support = new Stack<Integer>();

    public Problem30() {
        data = new Stack<Integer>();
        support = new Stack<Integer>();
    }

    public void push(int x) {
        data.push(x);
        if (support.isEmpty())
            support.push(x);
        else
            support.push(x < support.peek() ? x : support.peek());
    }

    public void pop() {
        data.pop();
        support.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return support.peek();
    }
}
