package main.play_algorithm.chap9;

public class Integer_Break {

    public int integerBreak(int n) {
        int[] memo = new int[n+1];
        return breakInteger(n, memo);
    }


    private int breakInteger(int n, int[] memo) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n-i), i * breakInteger(n-i, memo)));
        }
        memo[n] = res;
        return res;
    }



    public int integerBreak2(int n) {
        //dp[i] 表示将数字i分隔后(至少两部分)得到的最大乘积
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }


}
