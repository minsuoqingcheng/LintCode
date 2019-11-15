package main.recruit.qiuzhao.zhaohang;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int[] results = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            int resultIndex = i;
            int count = 0;
            if (element == 'R') {
                count++;
                resultIndex++;
                char next = input.charAt(resultIndex);

                while (next == 'R') {
                    count++;
                    resultIndex++;
                    next = input.charAt(resultIndex);
                }
                if (count % 2 == 0) {
                    results[resultIndex]++;
                } else {
                    resultIndex--;
                    results[resultIndex]++;
                }
            }
            if (element == 'L') {
                count++;
                resultIndex--;
                char next = input.charAt(resultIndex);

                while (next == 'L') {
                    count++;
                    resultIndex--;
                    next = input.charAt(resultIndex);
                }
                if (count % 2 == 0) {
                    results[resultIndex]++;
                } else {
                    resultIndex++;
                    results[resultIndex]++;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            builder.append(results[i]).append(" ");
        }
        System.out.println(builder.substring(0, builder.length()-1));
    }

}
