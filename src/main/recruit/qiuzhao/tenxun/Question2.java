package main.recruit.qiuzhao.tenxun;

import java.util.*;

public class Question2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] xs = new int[n];
        List<Pair> pairs = new ArrayList<>();
        int m = 0;
        for (int i = 0; i < n; i++) {
            xs[i] = scanner.nextInt();
            m += xs[i];
            Pair pair = new Pair(scanner.nextInt(), i);
            pairs.add(pair);
        }
        pairs.sort(Comparator.comparing(Pair::getY));
        int[] data = new int[m];
        int dataIndex = 0;
        for (int i = 0; i < n; i++) {
            Pair pair = pairs.get(i);
            int index = pair.getIndex();
            int y = pair.getY();
            int x = xs[index];
            for (int j = 0; j < x; j++) {
                data[dataIndex] = y;
                dataIndex++;
            }
        }
        int max = 0;
        for (int i = 0; i < m / 2; i++) {
            int sum = data[i] + data[m-1-i];
            max = sum > max ? sum : max;
        }
        System.out.println(max);
    }


    private static class Pair {
        private int y;
        private int index;

        public Pair(int y, int index) {
            this.y = y;
            this.index = index;
        }

        public int getY() {
            return y;
        }

        public int getIndex() {
            return index;
        }
    }
}
