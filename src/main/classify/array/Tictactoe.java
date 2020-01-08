package main.classify.array;

public class Tictactoe {

    public String tictactoe(int[][] moves) {
        if (moves.length == 9) {
            String winner = getWinner(moves);
            if (winner == null) {
                return "Draw";
            }
            return winner;
        } else {
            String winner = getWinner(moves);
            if (winner == null) {
                return "Pending";
            }
            return winner;
        }
    }

    private String getWinner(int[][] moves) {
        boolean[][] playerA = new boolean[3][3];
        for (int i = 0; i < moves.length; i+=2) {
            int[] position = moves[i];
            playerA[position[0]][position[1]] = true;
        }
        boolean playerAResult = isWin(playerA);
        if (playerAResult) {
            return "A";
        }
        boolean[][] playerB = new boolean[3][3];
        for (int i = 1; i < moves.length; i+=2) {
            int[] position = moves[i];
            playerB[position[0]][position[1]] = true;
        }
        boolean playerBResult = isWin(playerB);
        if (playerBResult) {
            return "B";
        }
        return null;
    }


    private boolean isWin(boolean[][] player) {
         //check row
        for (int i = 0; i < 3; i++) {
            boolean success = true;
            for (int j = 0; j < 3; j++) {
                if (!player[i][j]) {
                    success = false;
                }
            }
            if (success) {
                return true;
            } else {
                success = true;
            }
        }
        //check column
        for (int i = 0; i < 3; i++) {
            boolean success = true;
            for (int j = 0; j < 3; j++) {
                if (!player[j][i]) {
                    success = false;
                }
            }
            if (success) {
                return true;
            } else {
                success = true;
            }
        }
        //check dialogue
        boolean success = true;
        for (int i = 0; i < 3; i++) {
            if (!player[i][i]) {
                success = false;
                break;
            }
        }
        if (success) {
            return true;
        }
        // /
        success = true;
        int i = 2;
        int j = 0;
        while (i >=0 && j <= 2) {
            if (!player[i][j]) {
                success = false;
                break;
            }
            i--;
            j++;
        }
        return success;
    }


    //[[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
    public static void main(String[] args) {
        Tictactoe test = new Tictactoe();
        System.out.println(test.tictactoe(new int[][]{{0,0}, {1,1}, {2,0}, {1,0}, {1, 2}, {2, 1}, {0,1}, {0,2}, {2,2}}));
    }
}
