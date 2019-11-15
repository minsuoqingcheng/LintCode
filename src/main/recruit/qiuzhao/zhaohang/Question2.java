package main.recruit.qiuzhao.zhaohang;

import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int value = scanner.nextInt();
            matrix[x-1][y-1] = value;
        }
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            int max = maxPath(matrix, i, n);
            results[i] = max;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(results[i]).append(" ");
        }
        System.out.println(builder.substring(0, builder.length()-1));
    }


    //4 2 0 0
    //3 6 0 0 0
    private static int maxPath(int[][] matrix, int x, int length) {
        if (x == length - 1) {
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (matrix[x][i] > max) {
                    max = matrix[x][i];
                }
            }
            return max;
        } else {
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (matrix[x][i] != 0) {
                    max = Math.max(max, matrix[x][i] + maxPath(matrix, i, length));
                }
            }
            return max;
        }

    }

}
