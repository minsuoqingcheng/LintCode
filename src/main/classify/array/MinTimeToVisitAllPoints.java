package main.classify.array;

public class MinTimeToVisitAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int deltX = Math.abs(points[i+1][0] - points[i][0]);
            int deltY = Math.abs(points[i+1][1] - points[i][1]);
            ans += Math.max(deltX, deltY);
        }
        return ans;
    }

}
