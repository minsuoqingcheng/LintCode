package main.classify.everyday;

import java.util.Arrays;

public class CalculateMinimumHP {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m-1] = 1;
        dp[n-1][m] = 1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int min = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.max(min-dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

}
