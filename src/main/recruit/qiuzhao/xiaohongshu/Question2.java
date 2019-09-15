package main.recruit.qiuzhao.xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Stack<Character> characters = new Stack<>();
        int invalidCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            if (element != '(' && element != ')' && element != '<' && invalidCount == 0) {
                characters.push(element);
            }
            if (element == '<' && invalidCount == 0) {
                if (!characters.isEmpty()) {
                    characters.pop();
                }
            }
            if (element == '(') {
                invalidCount++;
            }
            if (element == ')') {
                invalidCount--;
            }
        }
        StringBuilder output = new StringBuilder();
        while (!characters.isEmpty()) {
            output.append(characters.pop());
        }
        System.out.println(output.reverse().toString());
    }

}
