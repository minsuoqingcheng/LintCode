package main.play_algorithm_interview.chap4;

import java.util.HashMap;
import java.util.Map;

public class Number_of_Boomerangs {

    public int numberOfBoomerangs(int[][] points) {

        int ans = 0;
        int length = points.length;
        Map<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {
                if (j != i) {
                    int distance = calculateDistance(points[i], points[j]);
                    int times = record.getOrDefault(distance, 0);
                    times++;
                    record.put(distance, times);
                }
            }

            for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
                int times;
                if ((times = entry.getValue()) >= 2) {
                    ans += times * (times-1);
                }
            }

            record.clear();
        }

        return ans;

    }


    private int calculateDistance(int[] x, int[] y) {
        return (int) (Math.pow(x[0]-y[0], 2) + Math.pow(x[1]-y[1], 2));
    }


    public static void main(String[] args) {
        Number_of_Boomerangs test = new Number_of_Boomerangs();
        int ans = test.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        System.out.println(ans);
    }

}
