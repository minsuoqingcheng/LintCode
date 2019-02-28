package main.LeetCode.easy_to_250.question225;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private ArrayDeque<Integer> elements = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        elements.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return elements.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return elements.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return elements.isEmpty();
    }
}


// push - O(1), pop O(n)
class MyStack2 {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int topElement;

    /** Initialize your data structure here. */
    public MyStack2() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        topElement = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1) {
            topElement = q1.remove();
            q2.add(topElement);
        }
        int ele = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ele;
    }

    /** Get the top element. */
    public int top() {
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}


// push - O(n), pop O(1)
class MyStack3 {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int topElement;

    /** Initialize your data structure here. */
    public MyStack3() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        topElement = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ele = q1.remove();
        if (!q1.isEmpty()) {
            topElement = q1.peek();
        }
        return ele;
    }

    /** Get the top element. */
    public int top() {
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */