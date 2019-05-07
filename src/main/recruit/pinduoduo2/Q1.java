package main.recruit.pinduoduo2;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int result = 0;
        int temp = 0;
        do {
            temp = 0;
            char[] chars = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i+1]) {
                    i++;
                    temp++;
                } else {
                    sb.append(chars[i]);
                }
            }
            result += temp;
            input = sb.toString();
        } while (!input.isEmpty() && temp > 0);
        System.out.println(result);
    }


}
