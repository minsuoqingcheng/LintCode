package main.classify.array;

public class NumRookCaptures {

    public int numRookCaptures(char[][] board) {

        int[] point = new int[2];
        boolean get = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    point[0] = i;
                    point[1] = j;
                    get = true;
                    break;
                }
            }
            if (get) {
                break;
            }
        }

        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int x = point[0] + dir[0];
            int y = point[1] + dir[1];
            while (x >= 0 && y >= 0 && x < 8 && y < 8 && board[x][y] == '.') {
                x += dir[0];
                y += dir[1];
            }
            if (x < 0 || y < 0 || x == 8 || y == 8) {
                continue;
            }
            if (board[x][y] == 'p') {
                count++;
            }
        }

        return count;
    }

}
