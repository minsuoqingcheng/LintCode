package main.recruit.internship.huawei2;

import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            StringBuilder builder = new StringBuilder();
            int length = input.length();
            for (int i = 0; i < length; i++) {
                char c = input.charAt(i);
                if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ) {
                    builder.append(input.charAt(i));
                } else {
                    int left = i;
                    int leftCount = 0;
                    for (int j = left; j < length; j++) {
                        char lc = input.charAt(j);
                        if (lc == '(' || lc == '[' || lc == '{') {
                            leftCount++;
                        }
                        if (lc == ')' || lc == ']' || lc == '}') {
                            break;
                        }
                    }
                    int rightIndex = i+1;
                    while (rightIndex < length && leftCount > 0) {
                        char rc = input.charAt(rightIndex);
                        if (rc == ')' || rc == ']' || rc == '}') {
                            leftCount--;
                        }
                        rightIndex++;
                    }
                    String toParse = input.substring(i, rightIndex);
                    String parseResult = parse(toParse);
                    builder.append(parseResult);
                    i = rightIndex-1;
                }
            }

            String result = builder.reverse().toString();
            System.out.print(result);
        }

    }
    
    
    private static String parse(String expression) {
        Stack<Long> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();
        int length = expression.length();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') {
                StringBuilder number = new StringBuilder();
                number.append(c);
                for (int j = i+1; j < length; j++) {
                    char jc = expression.charAt(j);
                    if (jc >= '0' && jc <= '9') {
                        number.append(jc);
                    } else {
                        numbers.push(Long.valueOf(number.toString()));
                        i = j - 1;
                        break;
                    }
                }
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                StringBuilder digits = new StringBuilder();
                digits.append(c);
                for (int j = i+1; j < length; j++) {
                    char jc = expression.charAt(j);
                    if ((jc >= 'a' && jc <= 'z') || (jc >= 'A' && jc <= 'Z')) {
                        digits.append(jc);
                    } else {
                        strings.push(digits.toString());
                        i = j - 1;
                        break;
                    }
                }
            } else if (c == '(' || c == '[' || c == '{') {
                continue;
            } else {
                if (numbers.isEmpty()) {
                    return strings.pop();
                }
                long number = numbers.pop();
                String digit = strings.pop();
                StringBuilder builder = new StringBuilder();
                for (long j = 0; j < number; j++) {
                    builder.append(digit);
                }
                if (!strings.isEmpty()) {
                    String last = strings.pop();
                    last += builder.toString();
                    strings.push(last);
                } else {
                    strings.push(builder.toString());
                }
            }
        }
        return strings.pop();
    }


    private static char compare(char left) {
        if (left == '(') {
            return ')';
        } else if (left == '[') {
            return ']';
        } else {
            return '}';
        }
    }


}
