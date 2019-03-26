package main.bytedance;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String origin = scanner.next();
            System.out.println(fixString(origin));
        }

    }

    private static String fixString(String origin) {
        if (origin.length() <= 2) {
            return origin;
        }
        char[] chars = origin.toCharArray();
        StringBuilder sb = new StringBuilder();
        char first = chars[0];
        char second = chars[1];
        char third = second;
        //先找出第三个元素
        int index = 2;
        for (int i = 2; i < chars.length; i++) {
            index++;
            char current = chars[i];
            if (first == second) {
                if (current != second) {
                    third = current;
                    break;
                }
            } else {
                third = current;
                break;
            }

        }
        sb.append(first);
        sb.append(second);
        //第一个字符和第二个不相等 或者 第三个字符不等于第二个
        if (first != second || third != second) {
            sb.append(third);
        } else {
            return sb.toString();
        }
        for (int i = index; i < chars.length; i++) {
            char current = chars[i];
            if (first == second) {
                if (current != third) {
                    sb.append(current);
                    first = second;
                    second = third;
                    third = current;
                }
            } else {
                if (second == third) {
                    if (current != third) {
                        sb.append(current);
                        first = second;
                        second = third;
                        third = current;
                    }
                } else {
                    sb.append(current);
                    first = second;
                    second = third;
                    third = current;
                }
            }
        }
        return sb.toString();
    }

}
