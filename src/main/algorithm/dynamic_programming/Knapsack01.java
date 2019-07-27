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
