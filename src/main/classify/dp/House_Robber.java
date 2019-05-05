package main.classify.dp;

public class House_Robber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i+1] = Math.max(dp[i], dp[i-1]+val);
        }
        return dp[nums.length];
    }

}
