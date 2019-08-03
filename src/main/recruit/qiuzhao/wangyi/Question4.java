package main.recruit.qiuzhao.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Question4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int queryCount = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);
        for (int i = 0; i < queryCount; i++) {


            int x = scanner.nextInt();
            int result = 0;
            boolean modify = false;
            for (int j = n - 1; j >= 0; j--) {
                if (numbers[j] >= x) {
                    result++;
                    numbers[j] = numbers[j] - 1;
                    modify = true;
                } else {
                    break;
                }
            }
            if (modify) {
                Arrays.sort(numbers);
            }
            System.out.println(result);
        }
    }
}


//import java.util.Scanner;
//        import java.util.Arrays;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int queryCount = scanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//        Arrays.sort(numbers);
//        for (int i = 0; i < queryCount; i++) {
//            int x = scanner.nextInt();
//            System.out.println(satisfyCount(n, numbers, x));
//        }
//    }
//
//
//    private static int satisfyCount(int n, int[] numbers, int x) {
//        int result = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            if (numbers[i] >= x) {
//                result++;
//                numbers[i] = numbers[i] - 1;
//            } else {
//                break;
//            }
//        }
//        return result;
//    }
//
//}

