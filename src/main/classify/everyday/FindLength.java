package main.classify.everyday;

public class FindLength {

    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];

        int max = 0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i+1][j+1] + 1 : 0;
                max = Integer.max(dp[i][j], max);
            }
        }

        return max;
    }

}
