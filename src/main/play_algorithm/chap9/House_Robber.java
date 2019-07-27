package main.play_algorithm.chap9;

import java.util.Arrays;

public class House_Robber {

    public int rob(int[] nums) {
        int length = nums.length;
        int[] memo = new int[length];
        Arrays.fill(memo, -1);
        return tryRob(nums, length, 0, memo);
    }

    private int tryRob(int[] nums, int length, int index, int[] memo) {
        if (index >= length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int result = 0;
        for (int i = index; i < length; i++) {
            result = Math.max(result, nums[i] + tryRob(nums, length, i+2, memo));
        }
        memo[index] = result;
        return result;
    }


    public int rob1(int[] nums) {
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


    public static void main(String[] args) {
        House_Robber house_robber = new House_Robber();
        System.out.println(house_robber.rob(new int[]{1, 2}));
    }

}
