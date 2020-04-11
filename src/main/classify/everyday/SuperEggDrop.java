package main.classify.everyday;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {

    private Integer[][] memo = null;

    public int superEggDrop(int K, int N) {
        memo = new Integer[K+1][N+1];
        return dp(K, N);
    }

    private int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n <= 0) {
            return 0;
        }
        if (memo[k][n] != null) {
            return memo[k][n];
        }
        int tmp = Integer.MAX_VALUE;
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int eggBreak = dp(k-1, mid-1);
            int eggUnbreak = dp(k, n-mid);
            if (eggBreak > eggUnbreak) {
                hi = mid - 1;
                tmp = Math.min(tmp, eggBreak+1);
            } else {
                lo = mid + 1;
                tmp = Math.min(tmp, eggUnbreak+1);
            }
        }
        memo[k][n] = tmp;
        return tmp;
    }

}
