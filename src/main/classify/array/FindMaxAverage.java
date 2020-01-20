package main.classify.array;

public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

}
