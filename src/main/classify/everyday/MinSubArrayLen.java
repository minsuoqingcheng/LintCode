package main.classify.everyday;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
