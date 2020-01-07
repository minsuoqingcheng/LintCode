package main.classify.array;

public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum1 = 0;
        int total = 0;
        if (start > destination) {
            int temp = destination;
            destination = start;
            start = temp;
        }
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
            if (i >= start && i < destination) {
                sum1 += distance[i];
            }
        }
        return Math.min(sum1, total-sum1);
    }

}
