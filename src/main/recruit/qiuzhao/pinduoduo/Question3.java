package main.recruit.qiuzhao.pinduoduo;

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //任务数量
        int M = sc.nextInt();   //依赖关系数量

        int[] tasks = new int[N];
        int[][] depencies = new int[M][2];

        for (int i = 0; i < N; i++) {
            tasks[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            depencies[i][0] = sc.nextInt();
            depencies[i][1] = sc.nextInt();
        }

        printArray(N);
    }

    private static void printArray(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.subSequence(0, sb.length()-1));
    }

}
