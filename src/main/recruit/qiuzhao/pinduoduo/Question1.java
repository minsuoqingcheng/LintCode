package main.recruit.qiuzhao.pinduoduo;

import java.util.Scanner;

public class Question1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String[] inputa = input1.split(" ");
        String input2 = sc.nextLine();
        String[] inputb = input2.split(" ");
        long[] a = new long[inputa.length];
        long[] b = new long[inputb.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(inputa[i]);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.valueOf(inputb[i]);
        }

        int index = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i+1]) {
                index = i+1;
            }
        }
        if (index == 0) {
            prlongArray(a);
        }

        long lowPre = a[index-1];
        long lowAfter;
        if (index < a.length-1) {
            lowAfter = a[index+1];
        } else {
            lowAfter = Long.MAX_VALUE;
        }

        long result = Long.MIN_VALUE;
        for (int i = 0; i < b.length; i++) {
            if (b[i] > lowPre && b[i] <  lowAfter) {
                result = Math.max(result, b[i]);
            }
        }

        if (result != Long.MIN_VALUE) {
            a[index] = result;
            prlongArray(a);
        } else {
            System.out.println("NO");
        }
    }

    private static void prlongArray(long[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }
        System.out.println(sb.subSequence(0, sb.length()-1));
    }
}


