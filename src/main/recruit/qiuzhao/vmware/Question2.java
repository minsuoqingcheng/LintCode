package main.recruit.qiuzhao.vmware;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] as = new int[n];
        List<Pair> bIndex = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            as[i] = scanner.nextInt();
            bIndex.add(new Pair(scanner.nextInt(), i));
        }
        bIndex.sort(Comparator.comparing(Pair::getB));
        int bSum = 0;
        int count = 0;
        for (int i = 0; i < bIndex.size(); i++) {
            Pair pair = bIndex.get(i);
            int index = pair.index;
            int a = as[index];
            if (a >= n-1) {
                System.out.println(pair.b);
                break;
            } else {


            }
        }
    }



    private static class Pair {
        private int b;
        private int index;

        public Pair(int b, int index) {
            this.b = b;
            this.index = index;
        }

        public int getB() {
            return b;
        }

        public int getIndex() {
            return index;
        }
    }

}
