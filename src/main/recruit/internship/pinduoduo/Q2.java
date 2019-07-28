package main.recruit.internship.pinduoduo;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String lowerCaseInput = input.toLowerCase();
        char[] digits = lowerCaseInput.toCharArray();
        char result = digits[0];
        for (int i = 0; i < digits.length - 1; i++) {
            char current = digits[i];
            if (lowerCaseInput.lastIndexOf(current) == i) {
                result = current;
                break;
            } else {
                char next = digits[i+1];
                if (current < next) {
                    result = current;
                    break;
                }
            }
        }
        System.out.println(result);
    }

}
