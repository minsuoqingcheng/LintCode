package main.algorithm.backtrack;

/**
 * 0-1背包的回溯法解决
 */
public class ZeroOnePack {

    private int maxW = Integer.MIN_VALUE;

    /**
     *
     * @param i 代表当前的物品编号
     * @param cw 已经装进去的物品总和
     * @param items 物品的重量数组
     * @param n 物品总个数
     * @param w 背包重量
     */
    public void solve(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        solve(i+1, cw, items, n, w);    //代表当前物品不加入背包，直接考察下一个物品
        if (cw + items[i] <= w) {       //先将当前物品加入背包，再考察下一个物品
            solve(i+1, cw+items[i], items, n, w);
        }
    }


    /**
     * 回溯算法的优化
     * 对调用状态的记录
     */
    static class Solve2 {
        private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
        private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
        private int n = 5; // 物品个数
        private int w = 9; // 背包承受的最大重量
        private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值 false

        void f(int i, int cw) { // 调用 f(0, 0)
            if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
                if (cw > maxW) maxW = cw;
                return;
            }
            if (mem[i][cw]) return; // 重复状态
            mem[i][cw] = true; // 记录 (i, cw) 这个状态
            f(i+1, cw); // 选择不装第 i 个物品
            if (cw + weight[i] <= w) {
                f(i+1,cw + weight[i]); // 选择装第 i 个物品
            }
        }
}

}
