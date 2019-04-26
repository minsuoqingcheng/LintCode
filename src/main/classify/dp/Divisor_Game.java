package main.classify.dp;

public class Divisor_Game {

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i-x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

}
