package main.recruit.pinduoduo2;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] lefts = new int[n];
        int[] rights = new int[n];
        List<Point> origins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lefts[i] = sc.nextInt();
            rights[i] = sc.nextInt();
            origins.add(new Point(lefts[i], rights[i]));
        }
        List<Point> merge = new ArrayList<>();
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = 0;
            Point p = origins.get(i);
            for (int j = 0; j < n && j != i; j++) {
                Point compare = origins.get(j);
                //出现交叉,取出交叉部分
                if (!(p.left > compare.right || p.right < compare.left)) {
                    if (p.left >= compare.left && p.left <= compare.right) {
                        merge.add(new Point(p.left, compare.right));
                        temp++;
                    }
                    if (p.right >= compare.left && p.right <= compare.right) {
                        merge.add(new Point(compare.left, p.right));
                        temp++;
                    }
                    if (p.left >= compare.left && p.right <= compare.right) {
                        merge.add(p);
                        temp++;
                    }
                    //符合条件则将候选点合并
                    if (temp == k) {
                        int maxLeft = Integer.MIN_VALUE;
                        int minRight = Integer.MAX_VALUE;
                        for (Point aMerge : merge) {
                            maxLeft = Math.max(maxLeft, aMerge.left);
                            minRight = Math.min(minRight, aMerge.right);
                            result.add(new Point(maxLeft, minRight));
                        }
                        temp = 0;
                        merge.clear();
                    }
                }
            }
        }

        System.out.println(result.size());
        for (Point point : result) {
            System.out.println(point.left + " " + point.right);
        }
    }


    private static class Point {
        int left;
        int right;

        Point(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

    }

}
