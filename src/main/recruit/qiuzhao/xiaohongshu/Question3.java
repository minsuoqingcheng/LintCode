package main.recruit.qiuzhao.xiaohongshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int pages = scanner.nextInt();
        int[] priseCount = new int[pages];
        for (int i = 0; i < pages; i++) {
            priseCount[i] = scanner.nextInt();
        }

        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < pages; i++) {
            if (priseCount[i] == 0) {
                zeros.add(i);
            }
        }

        /**
         * 6
            5 6 9 7 1 5
         */
        if (zeros.isEmpty()) {
            int size = pages/2 + pages%2;
            int[] dp = new int[size];
            for (int i = 0; i < size; i++) {

            }


            int evenTotalPrise = 0;
            int evenTotalPages = 0;
            int oddTotalPrise = 0;
            int oddTotalPages = 0;
            for (int i = 0; i < pages - 1; i += 2) {
                evenTotalPrise += priseCount[i];
                evenTotalPages++;
            }
            for (int i = 1; i < pages; i += 2) {
                oddTotalPrise += priseCount[i];
                oddTotalPages++;
            }
            if (evenTotalPrise > oddTotalPrise) {
                System.out.println(evenTotalPrise + " " + evenTotalPages);
            } else {
                System.out.println(oddTotalPrise + " " + oddTotalPages);
            }

        } else {
            zeros.add(0, -1);
            zeros.add(pages);
            int resultPrise = 0;
            int resultPages = 0;
            for (int i = 0; i < zeros.size() - 1; i++) {
                int start = zeros.get(i);
                int end = zeros.get(i+1);
                int evenTotalPrise = 0;
                int evenTotalPages = 0;
                int oddTotalPrise = 0;
                int oddTotalPages = 0;
                if (end - start == 2) {
                    resultPrise += priseCount[start+1];
                    resultPages++;
                } else {
                    for (int j = start+1; j < end; j += 2) {
                        evenTotalPrise += priseCount[j];
                        evenTotalPages++;
                    }
                    for (int j = start+2; j < end; j += 2) {
                        oddTotalPrise += priseCount[j];
                        oddTotalPages++;
                    }
                    if (evenTotalPrise > oddTotalPrise) {
                        resultPrise += evenTotalPrise;
                        resultPages += evenTotalPages;
                    } else {
                        resultPrise += oddTotalPrise;
                        resultPages += oddTotalPages;
                    }
                }

            }
            System.out.println(resultPrise + " " + resultPages);
        }
    }

}
