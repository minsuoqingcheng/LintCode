package main.other;

public class EditDistance {

    /**
     * 假设我们有长度分别为i、j的两个字符串，设编辑距离为edit(i,j)。
     * 接着我们看下，如果它们最后的字符相等，则编辑距离其实等于edit(i-1,j-1)。
     * 而如果最后的字符不相等，那么我们可以通过插入或替换来使其相等，但是不同的操作对应的代价不相同，
     * 如果插入则为edit(i,j-1)+1 或 eidit(i-1,j)+1，替换则为edit(i-1,j-1)+1。
     */

    public static int getEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int cost;
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        int[][] d = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            d[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            d[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            char s_i = s.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char t_j = t.charAt(j-1);
                cost = (s_i == t_j) ? 0 : 1;
                d[i][j] = Math.min(d[i-1][j]+1, d[i][j-1]+1);
                d[i][j] = Math.min(d[i][j], d[i-1][j-1]+cost);
            }
        }
        return d[m][n];
    }

    public static void main(String[] args) {
        System.out.println(EditDistance.getEditDistance("what", "where"));
    }

}
