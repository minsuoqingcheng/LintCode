package main.algorithm.dynamic_programming;

/**
 * 0-1背包，动态规划求法，只计重量
 */
public class ZeroOnePack {

    public static int solve(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1];
        states[0] = true;
        states[items[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = w - items[i]; j >= 0; j--) {   //这边要从大往小遍历，否则会影响状态的更新
                if (states[j]) {
                    states[j+items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }

}
