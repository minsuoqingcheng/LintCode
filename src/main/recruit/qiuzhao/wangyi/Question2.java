package main.recruit.qiuzhao.wangyi;

import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int i = 0; i < caseCount; i++) {
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = scanner.nextInt();
            }
            System.out.println(success(n, numbers));
        }

    }


    private static String success(int n, int[] numbers) {
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += numbers[i];
        }
        double average = (double)total / n;
        int less = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] < average) {
                less++;
            }
        }
        if (less > n / 2) {
            return "NO";
        } else {
            return "YES";
        }
    }

}
