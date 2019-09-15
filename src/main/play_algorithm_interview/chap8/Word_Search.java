package main.play_algorithm_interview.chap8;

public class Word_Search {

    private int m;
    private int n;

    private int[][] direction = new int[][]{{-1, 0}, {0,1}, {1,0}, {0,-1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean search(char[][] board, int startM, int startN, String word, int index, boolean[][] visited) {
        if (index == word.length()-1) {
            return board[startM][startN] == word.charAt(index);
        }

        if (board[startM][startN] == word.charAt(index)) {
            visited[startM][startN] = true;

            for (int i = 0; i < 4; i++) {
                int nextM = startM - direction[i][0];
                int nextN = startN - direction[i][1];
                if (inArea(nextM, nextN) && !visited[nextM][nextN]) {
                    if (search(board, nextM, nextN, word, index+1, visited)) {
                        return true;
                    }
                }
            }

            visited[startM][startN] = false;
        }
        return false;
    }


    private boolean inArea(int startM, int startN) {
        return startM >= 0 && startM < m && startN >= 0 && startN < n;
    }

}
