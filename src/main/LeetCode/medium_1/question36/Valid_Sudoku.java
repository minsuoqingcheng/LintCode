package main.LeetCode.medium_1.question36;

import java.util.ArrayList;
import java.util.List;

public class Valid_Sudoku {

    @SuppressWarnings("Duplicates")
    public boolean isValidSudoku(char[][] board) {
        char zero = '0';
        //row
        for (int i = 0; i < 9; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                int data = board[i][j] - zero;
                if (data >= 1 && data <= 9) {
                    if (numbers.contains(data)) {
                        return false;
                    } else {
                        numbers.add(data);
                    }
                }
            }
        }
        //column
        for (int i = 0; i < 9; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                int data = board[j][i] - zero;
                if (data >= 1 && data <= 9) {
                    if (numbers.contains(data)) {
                        return false;
                    } else {
                        numbers.add(data);
                    }
                }
            }
        }
        //square
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                List<Integer> numbers = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int data = board[i+k][j+l] - zero;
                        if (data >= 1 && data <= 9) {
                            if (numbers.contains(data)) {
                                return false;
                            } else {
                                numbers.add(data);
                            }
                        }
                    }

                }
            }
        }
        return true;
    }


    public boolean isValidSudoku2(char[][] board) {
        int[] bit_map_row = new int[9];
        int[] bit_map_col = new int[9];
        int[] bit_map_cube = new int[9];

        for (int row=0; row<9;row++){

            for (int col=0; col<9;col++){
                if(board[row][col] != '.'){

                    int value = 1 << (board[row][col] -'1');

                    if ((bit_map_row[row] & value) > 0){
                        return false;
                    }else{

                        bit_map_row[row] |= value;
                    }

                    if ((bit_map_col[col] & value) > 0){
                        return false;
                    }else {
                        bit_map_col[col] |= value;
                    }

                    int cubeIndex = 3*(row/3) + col/3;
                    if ((bit_map_cube[cubeIndex] & value) > 0){
                        return false;
                    }else {
                        bit_map_cube[cubeIndex] |= value;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Valid_Sudoku test = new Valid_Sudoku();
        System.out.println(1 << 3);
    }


}
