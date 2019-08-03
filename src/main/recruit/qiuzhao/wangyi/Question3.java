package main.recruit.qiuzhao.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        boolean hasDifference = judge(n, numbers);
        if (!hasDifference) {
            printArray(n, numbers);
        } else {
            Arrays.sort(numbers);
            printArray(n, numbers);
        }
    }


    private static boolean judge(int n, int[] numbers) {
        int base = numbers[0] % 2;
        for (int i = 1; i < n; i++) {
            if (numbers[i] % 2 != base) {
                return true;
            }
        }
        return false;
    }


    private static void printArray(int n, int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]);
            sb.append(" ");
        }
        System.out.println(sb.subSequence(0, sb.length()-1));
    }
}
