package main.algorithm.dynamic_programming;

import java.util.Arrays;

public class Knapsack01 {

    /**
     *
     * @param weights 物品重量
     * @param values 物品价值
     * @param C 背包总重量
     * @return
     */
    public int knapsack01(int[] weights, int[] values, int C) {
        int[][] memo = new int[weights.length][C+1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return bestValue(weights, values, weights.length-1, C, memo);
    }



    public int knapsack01_2(int[] weights, int[] values, int C) {
        int n = weights.length;
        if (n == 0) {
            return 0;
        }
        //memo[i][j]的值: 在背包重要为j时，放入i个物品的最大价值
        int[][] memo = new int[n][C+1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int j = 0; j <= C; j++) {
            memo[0][j] = (j >= weights[0] ? values[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i-1][j];
                if (j >= weights[i]) {
                    memo[i][j] = Math.max(memo[i][j], values[i] + memo[i-1][j-weights[i]]);
                }
            }
        }
        return memo[n-1][C];
    }


    /**
     * 优化，每一行只依赖上一行，dp数组只需要2行
     * @param weights
     * @param values
     * @param C
     * @return
     */
    public int knapsack01_3(int[] weights, int[] values, int C) {
        int n = weights.length;
        if (n == 0) {
            return 0;
        }
        //memo[i][j]的值: 在背包重要为j时，放入i个物品的最大价值
        int[][] memo = new int[2][C+1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int j = 0; j <= C; j++) {
            memo[0][j] = (j >= weights[0] ? values[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i%2][j] = memo[(i-1)%2][j];
                if (j >= weights[i]) {
                    memo[i%2][j] = Math.max(memo[i%2][j], values[i] + memo[(i-1)%2][j-weights[i]]);
                }
            }
        }
        return memo[(n-1)%2][C];
    }


    /**
     * 只需要一行存储0-1的结果，时间、空间常数级优化
     * @param weights
     * @param values
     * @param C
     * @return
     */
    public int knapsack01_4(int[] weights, int[] values, int C) {
        int n = weights.length;
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[C+1];
        Arrays.fill(memo, -1);
        for (int j = 0; j <= C; j++) {
            memo[j] = (j > weights[0] ? values[0] : 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = C; j >= weights[i]; j--) {
                memo[j] = Math.max(memo[j], values[i] + memo[j-weights[i]]);
            }
        }

        return memo[C];
    }


    /**
     * 用[0...index]的物品，填充容积为c的背包的最大价值
     * @param weights
     * @param values
     * @param index
     * @param c
     * @return
     */
    private int bestValue(int[] weights, int[] values, int index, int c, int[][] memo) {
        if (index < 0 || c <= 0) {
            return 0;
        }

        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = bestValue(weights, values, index-1, c, memo);
        if (c >= weights[index]) {
            res = Math.max(res, values[index] + bestValue(weights, values, index-1, c-weights[index], memo) + weights[index]);
        }
        memo[index][c] = res;
        return res;
    }
}
