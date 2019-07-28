package main.recruit.internship.bytedance;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int left = 1024 - price;
        int count1 = left / 64;
        left -= count1 * 64;
        int count2 = left / 16;
        left -= count2 * 16;
        int count3 = left / 4;
        left -= count3 * 4;
        System.out.println(count1+count2+count3+left);
    }

}
