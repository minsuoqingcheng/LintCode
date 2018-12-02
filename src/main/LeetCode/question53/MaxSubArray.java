package main.LeetCode.question53;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = sum < 0 ? 0 : sum;
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }

}
