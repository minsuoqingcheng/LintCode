package main.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalSort {

    public int[][] diagonalSort(int[][] mat) {
        int rowLength = mat.length;
        int columnLength = mat[0].length;
        int columnIndex = columnLength - 1;
        int rowIndex = 0;
        while (columnIndex >= 0) {
            sort(mat, rowIndex, columnIndex, rowLength, columnLength);
            columnIndex--;
        }
        columnIndex++;
        while (rowIndex < mat.length) {
            sort(mat, rowIndex, columnIndex, rowLength, columnLength);
            rowIndex++;
        }
        return mat;
    }

    private void sort(int[][] mat, int rowIndex, int columnIndex, int rowLength, int columnLength) {
        List<Integer> nums = new ArrayList<>();
        while (rowIndex < rowLength && columnIndex < columnLength) {
            nums.add(mat[rowIndex][columnIndex]);
            rowIndex++;
            columnIndex++;
        }
        int size = nums.size();
        int[] res = new int[size];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }
        Arrays.sort(res);
        rowIndex--;
        columnIndex--;
        int index = 1;
        while (rowIndex >= 0 && columnIndex >=0) {
            mat[rowIndex][columnIndex] = res[size-index];
            index++;
            rowIndex--;
            columnIndex--;
        }
    }
}
