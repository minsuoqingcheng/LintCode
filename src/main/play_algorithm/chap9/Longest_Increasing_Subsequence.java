package main.play_algorithm.chap9;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], 1+memo[j]);
                }
            }
            res = Math.max(res, memo[i]);
        }

        return res;
    }

}
