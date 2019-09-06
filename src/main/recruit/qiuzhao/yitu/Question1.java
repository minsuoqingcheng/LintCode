package main.recruit.qiuzhao.yitu;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] data = new int[count];
        for (int i = 0; i < count; i++) {
            data[i] = scanner.nextInt();
        }
        int modifyCount = 0;
        for (int i = 0; i < count; i++) {
            if (data[i] == 1) {
                continue;
            } else if (i > 0 && data[i-1] == 1) {
                continue;
            } else if (i != count-1 && data[i+1] == 1) {
                continue;
            } else {
                modifyCount++;
                data[i] = 1;
            }
        }
        System.out.println(modifyCount);
    }

}
