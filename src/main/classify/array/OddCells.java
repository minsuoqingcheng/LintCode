package main.classify.array;

public class OddCells {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] res = new int[n][m];
        for (int[] indice : indices) {
            //row
            int row = indice[0];
            int[] resrow = res[row];
            for (int i = 0; i < m; i++) {
                resrow[i]++;
            }
            //column
            int column = indice[1];
            for (int i = 0; i < n; i++) {
                res[i][column]++;
            }
        }
        //calculate odd cells
        int oddCells = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] % 2 != 0) {
                    oddCells++;
                }
            }
        }
        return oddCells;
    }

}
