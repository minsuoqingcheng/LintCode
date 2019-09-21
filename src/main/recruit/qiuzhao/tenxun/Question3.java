package main.recruit.qiuzhao.tenxun;

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int i = 0; i < caseCount; i++) {
            int n = scanner.nextInt();
            int[] xs = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                xs[j] = scanner.nextInt();
                sum += xs[j];
            }
            if (sum % 2 == 0) {
                System.out.println(sum/2);
                System.out.println(sum/2);
            } else {
                System.out.println(sum/2);
                System.out.println(sum/2+1);
            }
        }

    }

}
