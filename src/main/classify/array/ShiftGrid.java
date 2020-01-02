package main.classify.array;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length;
        int column = grid[0].length;

        //init
        /**
         * 注意：List的构造函数传入的值是初始化List的大小，不会对元素进行初始化
         */
        List<List<Integer>> res = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            List<Integer> elements = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                elements.add(0);
            }
            res.add(elements);
        }

        //set
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int newColumn = (j + k) % column;
                int wrapCount = (j + k) / column;
                int newRow = (i + wrapCount) % row;
                res.get(newRow).set(newColumn, grid[i][j]);

            }
        }

        return res;
    }

    public static void main(String[] args) {
        ShiftGrid shiftGrid = new ShiftGrid();
        shiftGrid.shiftGrid(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}, 1);
    }

}
