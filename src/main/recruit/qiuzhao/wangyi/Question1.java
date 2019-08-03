package main.recruit.qiuzhao.wangyi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }
        int p = in.nextInt();
        for (int i = 0; i < p; i++) {
            int index = in.nextInt();
            System.out.println(ratio(n, scores, index));
        }

    }


    private static String ratio(int n, int[] scores, int index) {
        int score = scores[index-1];
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] <= score) {
                total++;
            }
        }
        double result = (((double)(total - 1)) / n) * 100;
        BigDecimal bigDecimal = BigDecimal.valueOf(result).setScale(6, RoundingMode.HALF_UP);
        return bigDecimal.toString();
    }

}
