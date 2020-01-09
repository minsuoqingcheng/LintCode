package main.classify.array;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int column = M[0].length;

        int[][] res = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                res[i][j] = smooth(M, i, j, row, column);
            }
        }

        return res;
    }

    private int smooth(int[][] M, int x, int y, int row, int column) {
        int count = 0;
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x+i < 0 || x+i >= row || y+j < 0 || y+j >= column) {
                    continue;
                }
                count++;
                sum += M[x+i][y+j];
            }
        }
        return sum / count;
    }

}
