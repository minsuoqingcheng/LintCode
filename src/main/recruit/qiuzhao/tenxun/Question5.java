package main.recruit.qiuzhao.tenxun;

import java.util.Scanner;

public class Question5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] as = new int[n];
        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bs[i] = scanner.nextInt();
        }
        int[] nums = new int[n*n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[index] = as[i] + bs[i];
                index++;
            }
        }
        int result = nums[0];
        for (int i = 1; i < n*n; i++) {
            result = result ^ nums[i];
        }
        System.out.println(result);
    }

}
