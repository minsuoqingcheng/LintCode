package main.classify.array;

import java.util.ArrayList;
import java.util.List;

public class MatrixReshape {


    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (row * column != r * c) {
            return nums;
        }
        List<Integer> data = new ArrayList<>();
        //store
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                data.add(nums[i][j]);
            }
        }
        //get and set
        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = data.get(index++);
            }
        }
        return res;
    }

}
