package main.play_algorithm.chap9;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {

    private int[][] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        memo = new int[nums.length][sum/2+1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return tryPartition(nums, nums.length-1, sum/2);

    }


    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int C = sum / 2;
        boolean[] dp = new boolean[C+1];

        for (int i = 0; i <= C; i++) {
            dp[i] = (nums[0] == i);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = C; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[C];
    }


    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }

        boolean res = tryPartition(nums, index - 1, sum) || tryPartition(nums, index-1, sum-nums[index]);
        memo[index][sum] = res ? 1 : 0;
        return res;
    }

}
