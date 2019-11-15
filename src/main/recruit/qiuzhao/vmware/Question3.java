package main.recruit.qiuzhao.vmware;

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int k = scanner.nextInt();
        if (k - 1 < 2) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            boolean satisfy = true;
            for (int j = 2; j < k; j++) {
                if (i % j == 0) {
                    satisfy = false;
                    break;
                }
            }
            if (!satisfy) {
                continue;
            }
            if (i % k == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

}
