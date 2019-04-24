package main.classify.math;

public class Largest_Triangle_Area {

    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    max = Math.max(max, area(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }


    private double area(int[] p, int[] q, int[] r) {
        return 0.5 * Math.abs(p[0]*q[1] + q[0]*r[1] + r[0]*p[1]
                        - q[0]*p[1] - r[0]*q[1] - p[0]*r[1]);
    }

}
