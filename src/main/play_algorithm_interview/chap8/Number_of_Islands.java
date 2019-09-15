package main.play_algorithm_interview.chap8;

public class Number_of_Islands {

    private int m;
    private int n;

    private int[][] direction = new int[][]{{-1, 0}, {0,1}, {1,0}, {0,-1}};


    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        m = grid.length;
        n = grid[0].length;


        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }


    private void dfs(char[][] grid, int startM, int startN, boolean[][] visited) {
        visited[startM][startN] = true;
        for (int i = 0; i < 4; i++) {
            int nextM = startM - direction[i][0];
            int nextN = startN - direction[i][1];
            if (inArea(nextM, nextN) && !visited[nextM][nextN] && grid[nextM][nextN] == '1') {
                dfs(grid, nextM, nextN, visited);
            }
        }
    }




    private boolean inArea(int startM, int startN) {
        return startM >= 0 && startM < m && startN >= 0 && startN < n;
    }


}
