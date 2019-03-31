package main.algorithm.dynamic_programming;

/**
 * 0-1背包，动态规划求法，有价值
 */
public class ZeroOneValuePack {

    public int solve(int[] weight, int[] value, int n, int w) {
        int[][] state = new int[n][w+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                state[i][j] = -1;
            }
        }
        state[0][0] = 0;
        state[0][weight[0]] = value[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (state[i-1][j] > 0) {    //第i个元素不放进去
                    state[i][j] = state[i-1][j];
                }
            }
            //第i个元素放进去
            for (int j = 0; j <= w-weight[i]; j++) {
                if (state[i-1][j] > 0) {
                    int v = state[i-1][j] + value[i];
                    if (v > state[i][j+weight[i]]) {
                        state[i][j+weight[i]] = v;
                    }
                }
            }
        }
        int maxV = -1;
        for (int i = w; i >= 0; i--) {
            if (state[n-1][i] > maxV) {
                maxV = state[n-1][i];
            }
        }
        return maxV;
    }

}
