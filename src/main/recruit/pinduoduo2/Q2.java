package main.recruit.pinduoduo2;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] x = new int[K];
        int total = 0;
        for (int i = 0; i < K; i++) {
            x[i] = sc.nextInt();
            total += x[i];
        }
        Arrays.sort(x);
        int max = x[0];
        int min = 0;
        while (min <= max) {
            int middle = (max + min) / 2;
            int temp = total - middle * K + middle;
            if (temp == N) {
                System.out.println(middle);
                break;
            } else if (temp > N) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        if (min > max) {
            System.out.println(0);
        }
    }

}
