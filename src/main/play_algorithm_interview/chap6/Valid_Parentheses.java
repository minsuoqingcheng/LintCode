package main.play_algorithm_interview.chap6;

import java.util.Stack;

public class Valid_Parentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top  = stack.pop();
                char match;
                switch (c) {
                    case '}':
                        match = '{';
                        break;
                    case ']':
                        match = '[';
                        break;
                    case ')':
                        match = ')';
                        break;
                    default:
                        return false;
                }
                if (top != match) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
