package main.classify.array;

public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int[] firstPoint = coordinates[0];
        int[] comparePoint = coordinates[1];
        double value = (double) (comparePoint[1] - firstPoint[1]) / (comparePoint[0] - firstPoint[0]);
        for (int i = 2; i < coordinates.length; i++) {
            int[] current = coordinates[i];
            double temp = (double)(current[1] - comparePoint[1]) / (current[0] - comparePoint[0]);
            if (temp != value) {
                return false;
            }
            comparePoint = current;
        }
        return true;
    }

}
