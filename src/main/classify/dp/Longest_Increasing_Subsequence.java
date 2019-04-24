package main.classify.dp;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ret = 1;
        for (int i = 1; i < nums.length; i++) {
            int subMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    subMax = Math.max(subMax, dp[j]);
                }
            }
            dp[i] = subMax + 1;
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }


    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if (i < 0) {
                i = -(i+1);
            }
            dp[i] = num;
            if (i == length) {
                length++;
            }
        }
        return length;
    }
}
