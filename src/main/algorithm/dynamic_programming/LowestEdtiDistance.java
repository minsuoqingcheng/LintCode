package main.algorithm.dynamic_programming;

public class LowestEdtiDistance {

    public int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第 0 行:a[0..0] 与 b[0..j] 的编辑距离
            if (a[0] == b[j]) {
                minDist[0][j] = j;
            }
            else if (j != 0) {
                minDist[0][j] = minDist[0][j-1]+1;
            } else {
                minDist[0][j] = 1;
            }
        }
        for (int i = 0; i < n; ++i) { // 初始化第 0 列:a[0..i] 与 b[0..0] 的编辑距离
            if (a[i] == b[0]) {
                minDist[i][0] = i;
            }
            else if (i != 0) {
                minDist[i][0] = minDist[i-1][0]+1;
            } else {
                minDist[i][0] = 1;
            }
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) {
                    minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]);
                } else {
                    minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1);
                }
            }
        }
        return minDist[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }


}
