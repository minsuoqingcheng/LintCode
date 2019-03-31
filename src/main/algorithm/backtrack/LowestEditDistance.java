package main.algorithm.backtrack;

public class LowestEditDistance {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    private int minDist = Integer.MAX_VALUE; // 存储结果

    // 调用方式 lwstBT(0, 0, 0);
    public void lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) {
                edist += n - i;
            }
            if (j < m) {
                edist += m - j;
            }
            if (edist < minDist) {
                minDist = edist;
            }
            return;
        }
        if (a[i] == a[j]) {
            lwstBT(i+1, j+1, edist);
        } else {
            lwstBT(i, j+1, edist);
            lwstBT(i+1, j, edist);
            lwstBT(i+1, j+1, edist);
        }
    }


}
