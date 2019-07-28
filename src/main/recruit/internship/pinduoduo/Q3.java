package main.recruit.internship.pinduoduo;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] locations = new int[n];
        int[] money = new int[n];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            locations[i] = sc.nextInt();
            int value = sc.nextInt();
            money[i] = value;
            if (value > max) {
                max = value;
                maxIndex = i;
            }
        }
        int left = maxIndex - 1;
        max = 0;
        while (left >= 0) {
            if (locations[maxIndex] - locations[left] >= d) {
                int sum = money[maxIndex] + money[left];
                if (sum > max) {
                    max = sum;
                }
            }
            left--;
        }
        int right = maxIndex + 1;
        while (right < n) {
            if (locations[right] - locations[maxIndex] >= d) {
                int sum = money[maxIndex] + money[right];
                if (sum >= max) {
                    max = sum;
                }
            }
            right++;
        }
        int leftIndex = maxIndex - 1;
        int rightIndex = maxIndex + 1;
        while (leftIndex >= 0 && locations[maxIndex] - locations[leftIndex] < d) {
            leftIndex--;

        }
        while (rightIndex < n && locations[rightIndex] - locations[maxIndex] < d) {
            rightIndex++;
        }
        leftIndex++;
        rightIndex--;
        for (int i = leftIndex; i < maxIndex; i++) {
            for (int j = maxIndex + 1; j <= rightIndex; j++) {
                if (locations[j] - locations[i] >= d) {
                    int temp = money[j] + money[i];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }

}
