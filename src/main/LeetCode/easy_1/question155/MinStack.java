package main.LeetCode.easy_1.question155;

import java.util.Stack;

class MinStack {

    private int MIN = Integer.MAX_VALUE;
    private Stack<Integer> elements = new Stack<>();


    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if (x <= MIN) {
            elements.push(MIN);     //store last min value
            MIN = x;
        }
        elements.push(x);
    }
    
    public void pop() {
        int element = elements.pop();
        if (element == MIN) {
            MIN = elements.pop();
        }
    }
    
    public int top() {
        return elements.peek();
    }
    
    public int getMin() {
        return MIN;
    }

}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */