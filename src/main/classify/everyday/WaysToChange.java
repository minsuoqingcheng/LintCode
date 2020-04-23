package main.classify.everyday;

public class WaysToChange {

    private int mod = 1000000007;
    private int[] expr = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < expr.length; i++) {
            int coin = expr[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j-coin]) % mod;
            }
        }
        return dp[n];
    }

}
