package main.recruit.qiuzhao.zhaohang;

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.next();
        int start = pattern.charAt(0) - '0';
        int length = pattern.length();
        int min = (int) (start * Math.pow(10, length-1));
        int max = (int) ((start + 1) * Math.pow(10, length-1));
        int first = 0;
        int count = 0;
        for (int i = min; i < max; i++) {
            if (i % 13 == 8) {
                first = i;
                count++;
                break;
            }
        }
        for (int i = first + 13; i < max; i += 13) {
            count++;
        }
        System.out.println((int) (count % (Math.pow(10, 9) + 7)));
    }

}
