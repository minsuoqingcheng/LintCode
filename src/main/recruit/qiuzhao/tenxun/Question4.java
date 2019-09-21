package main.recruit.qiuzhao.tenxun;

import java.util.Arrays;
import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = scanner.nextInt();
        }
        for (int i = 0; i < k; i++) {
            Arrays.sort(as);
            int index = 0;
            int min = as[index];
            while (min == 0 && index < n) {
                min = as[index];
                index++;
            }
            if (index == n) {
                System.out.println(0);
                continue;
            }
            System.out.println(min);
            for (int j = 0; j < n; j++) {
                if (as[j] != 0) {
                    as[j] = as[j] - min;
                }
            }

        }
    }

}
