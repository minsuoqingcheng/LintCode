package main.algorithm.dynamic_programming;

public class Double11Advance {

    // items 商品价格，n 商品个数, w 表示满减条件，比如 200
    public static void double11advance(int[] items, int n, int w) {

        boolean[][] states = new boolean[n][3*w+1];// 超过 3 倍就没有薅羊毛的价值了
        states[0][0] = true;  // 第一行的数据要特殊处理
        states[0][items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = 0; j <= 3*w; ++j) {// 不购买第 i 个商品
                if (states[i - 1][j]) {
                    states[i][j] = states[i-1][j];
                }
            }
            for (int j = 0; j <= 3*w-items[i]; ++j) {// 购买第 i 个商品
                if (states[i - 1][j]) {
                    states[i][j+items[i]] = true;
                }
            }
        }

        int j;
        for (j = w; j < 3*w+1; ++j) {
            if (states[n - 1][j]) {
                break; // 输出结果大于等于 w 的最小值
            }
        }
        if (j == 3*w+1) {
            return; // 没有可行解
        }
        for (int i = n-1; i >= 1; --i) { // i 表示二维数组中的行，j 表示列
            if(j-items[i] >= 0 && states[i - 1][j - items[i]]) {
                System.out.print(items[i] + " "); // 购买这个商品
                j = j - items[i];
            } // else 没有购买这个商品，j 不变。
        }
        if (j != 0) {
            System.out.print(items[0]);
        }
    }


}
