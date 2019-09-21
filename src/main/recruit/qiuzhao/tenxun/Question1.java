package main.recruit.qiuzhao.tenxun;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int i = 0; i < caseCount; i++) {
            int length = scanner.nextInt();
            String number = scanner.next();
            if (length == 11) {
                if (number.startsWith("8")) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (length < 11) {
                System.out.println("NO");
            } else {
                int delete = length - 11;
                String sub = number.substring(0, delete+1);
                if (sub.contains("8")) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

}
