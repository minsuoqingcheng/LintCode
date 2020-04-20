package main.classify.everyday;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    count++;
                    Queue<int[]> neighbor = new LinkedList<>();
                    neighbor.add(new int[]{i, j});
                    while (!neighbor.isEmpty()) {
                        int[] select = neighbor.remove();
                        int selectRow = select[0];
                        int selectColumn = select[1];
                        if (selectRow - 1 >= 0 && grid[selectRow-1][selectColumn] == '1') {
                            neighbor.add(new int[]{selectRow-1, selectColumn});
                            grid[selectRow-1][selectColumn] = '0';
                        }
                        if (selectRow + 1 < row && grid[selectRow+1][selectColumn] == '1') {
                            neighbor.add(new int[]{selectRow+1, selectColumn});
                            grid[selectRow+1][selectColumn] = '0';
                        }
                        if (selectColumn - 1 >= 0 && grid[selectRow][selectColumn-1] == '1') {
                            neighbor.add(new int[]{selectRow, selectColumn-1});
                            grid[selectRow][selectColumn-1] = '0';
                        }
                        if (selectColumn + 1 < column && grid[selectRow][selectColumn+1] == '1') {
                            neighbor.add(new int[]{selectRow, selectColumn+1});
                            grid[selectRow][selectColumn+1] = '0';
                        }
                    }

                }
            }
        }
        return count;
    }

}
