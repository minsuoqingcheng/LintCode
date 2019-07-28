package main.recruit.internship.bytedance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] N = new int[n];
        for (int i = 0; i < n; i++) {
            N[i] = scanner.nextInt();
        }
        double maxLength = getLength(N, n, m);
        System.out.println(BigDecimal.valueOf(maxLength).setScale(2, RoundingMode.FLOOR));
    }

    private static double getLength(int[] N, int n, int m) {
        Arrays.sort(N);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += N[i];
        }
        double average = ((double) sum) / n;
        int max = N[n-1];
        if (m <= n && max < 2 * average) {
            return N[0];
        }
        return 0;
    }

}
