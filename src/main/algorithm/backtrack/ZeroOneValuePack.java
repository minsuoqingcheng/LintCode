package main.algorithm.backtrack;

public class ZeroOneValuePack {

    private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
    private int[] items = {2, 2, 4, 6, 3};  // 物品的重量
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    /**
     *
     * @param i 第i个元素
     * @param cw 累积总量
     * @param cv 累积价值
     */
    public void f(int i, int cw, int cv) {
        if (cw == w || i == n) {
            if (cv > maxV) {
                maxV = cv;
            }
            return;
        }
        f(i+1, cw, cv);     //选择不装第i个元素
        if (cw + items[i] <= w) {
            f(i+1, cw+items[i], cv+value[i]);
        }
    }


}

