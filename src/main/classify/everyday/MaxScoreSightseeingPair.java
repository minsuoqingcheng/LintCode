package main.classify.everyday;

public class MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int tempMax = A[0];
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, tempMax + A[i] - i);
            tempMax = Math.max(tempMax, A[i] + i);
        }
        return ans;
    }

}
