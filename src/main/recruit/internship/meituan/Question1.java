package main.recruit.internship.meituan;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(0);
        }
        int centerX = n / 2;
        int centerY = m / 2;
        int element = data[centerX][centerY];
        

    }

}
