package main.play_algorithm.chap8;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2*n-1];
        boolean[] dia2 = new boolean[2*n-1];

        search(n, 0, new ArrayList<>(), res, col, dia1, dia2);

        return res;
    }

    private void search(int n, int index, List<Integer> queens, List<List<String>> res,
                        boolean[] col, boolean[] dia1, boolean[] dia2) {
        if (index == n) {
            res.add(new ArrayList<>(generateBoard(n, new ArrayList<>(queens))));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index+i] && !dia2[index-i+n-1]) {
                queens.add(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                search(n, index+1, queens, res, col, dia1, dia2);
                queens.remove(queens.size()-1);
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
            }
        }
    }


    private List<String> generateBoard(int n, List<Integer> queens) {
        List<String> board = new ArrayList<>();
        for (Integer queen : queens) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j != queen) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }


    public static void main(String[] args) {
        N_Queens n_queens = new N_Queens();
        System.out.println(n_queens.solveNQueens(4));
    }
}
