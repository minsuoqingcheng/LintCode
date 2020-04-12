package main.classify.everyday;

import java.util.Arrays;

public class Intersection {

    /**
     * 直线的参数方程式
     * {
     *     x = x1 + t(x2 - x1)
     *     y = y1 + t(y2 - y1)
     * }
     *
     *
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        Double[] res = new Double[2];
        int x1 = start1[0], y1 = start1[1];
        int x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1];
        int x4 = end2[0], y4 = end2[1];

        //两个线段平行
        if ((y4 - y3) * (x2 - x1) == (y2 - y1) * (x4 - x3)) {
            // 重合 判断点(x3, y3)是否在 (x1, y1)~(x2, y2)表示的直线上
            if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                if (inside(x1, y1, x2, y2, x3, y3)) {
                    swap(res, x3, y3);
                }
                if (inside(x1, y1, x2, y2, x4, y4)) {
                    swap(res, x4, y4);
                }
                if (inside(x3, y3, x4, y4, x1, y1)) {
                    swap(res, x1, y1);
                }
                if (inside(x3, y3, x4, y4, x2, x2)) {
                    swap(res, x2, y2);
                }
            }
        } else {
            // 不平行，会相交
            double t1 = (double)(x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 如果点在线段上，则 t1: [0, 1], t2 : [0, 1]
            if (0 <= t1 && t1 <= 1 && 0 <= t2 && t2 <= 1) {
                res[0] = x1 + t1 * (x2 - x1);
                res[1] = y1 + t1 * (y2 - y1);
            }
        }
        if (res[0] == null) {
            return new double[0];
        }
        return new double[]{res[0], res[1]};
    }


    /**
     * 判断点是否在线段上
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param xk
     * @param yk
     * @return
     */
    private boolean inside(int x1, int y1, int x2, int y2, int xk, int yk) {
        return (x1 == x2 || Math.min(x1, x2) <= xk && xk <= Math.max(x1, x2)) &&
                (y1 == y2 || Math.min(y1, y2) <= yk && yk <= Math.max(y1, y2));
    }

    private void swap(Double[] points, double xk, double yk) {
        if (points[0] == null) {
            points[0] = xk;
            points[1] = yk;
            return;
        }
        if (xk < points[0] || (xk == points[0] && yk < points[1])) {
            points[0] = xk;
            points[1] = yk;
        }
    }

    public static void main(String[] args) {
        Intersection test = new Intersection();
        System.out.println(Arrays.toString(
                test.intersection(new int[]{1, 0}, new int[]{1, 1}, new int[]{-1, 0}, new int[]{3, 2})
        ));
    }

}
