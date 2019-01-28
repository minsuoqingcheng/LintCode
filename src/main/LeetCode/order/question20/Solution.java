package main.LeetCode.order.question20;

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                    stack[head++] = '}';
                    break;
                case '[':
                    stack[head++] = ']';
                    break;
                case '(':
                    stack[head++] = ')';
                    break;
                default:
                    if (head == 0 || stack[--head] != c) {
                        return false;
                    }
            }
        }
        return head == 0;
    }


    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}