package main.recruit.pinduoduo2;

import java.util.Arrays;
import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();   //总数量
        int N = sc.nextInt();   //需要的数量
        int[] heights = new int[M];
        for (int i = 0; i < M; i++) {
            heights[i] = sc.nextInt();
        }
        Arrays.sort(heights);
        int total = Integer.MAX_VALUE;
        for (int i = 0; i <= M - N; i++) {
            int highestIndex = i + N - 1;
            int need = heights[highestIndex] * (N - 1);
            for (int j = i; j < highestIndex; j++) {
                need -= heights[j];
            }
            total = Math.min(total, need);
        }
        System.out.println(total);
    }

}
