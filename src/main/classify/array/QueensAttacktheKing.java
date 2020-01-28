package main.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensAttacktheKing {


    /**
     * 以King为中心，8个方向
     * @param queens
     * @param king
     * @return
     */
    public List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] seen = new boolean[8][8];
        for (int[] queen : queens) seen[queen[0]][queen[1]] = true;
        int[] dirs = {-1, 0, 1};
        for (int dx : dirs) {
            for (int dy : dirs) {
                if (dx == 0 && dy == 0) continue;
                int x = king[0], y = king[1];
                while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                    x += dx;
                    y += dy;
                    if (seen[x][y]) {
                        result.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        int up = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        List<Integer> leftUp = new ArrayList<>();
        List<Integer> rightUp = new ArrayList<>();
        List<Integer> leftDown = new ArrayList<>();
        List<Integer> rightDown = new ArrayList<>();
        for (int[] queen : queens) {
            if (king[0] - queen[0] > 0 && king[0] - queen[0] == king[1] - queen[1]) {
                if (leftUp.isEmpty()) {
                    leftUp.add(queen[0]);
                    leftUp.add(queen[1]);
                } else {
                    if (leftUp.get(0) < queen[0]) {
                        leftUp.set(0, queen[0]);
                        leftUp.set(1, queen[1]);
                    }
                }
                continue;
            }
            if (queen[0] > king[0] && queen[0] - king[0] == queen[1] - king[1]) {
                if (rightDown.isEmpty()) {
                    rightDown.add(queen[0]);
                    rightDown.add(queen[1]);
                } else {
                    if (rightDown.get(0) > queen[0]) {
                        rightDown.set(0, queen[0]);
                        rightDown.set(1, queen[1]);
                    }
                }
                continue;
            }
            if (queen[0] > king[0] && queen[0] - king[0] == king[1] - queen[1]) {
                if (leftDown.isEmpty()) {
                    leftDown.add(queen[0]);
                    leftDown.add(queen[1]);
                } else {
                    if (leftDown.get(0) > queen[0]) {
                        leftDown.set(0, queen[0]);
                        leftDown.set(1, queen[1]);
                    }
                }
                continue;
            }
            if (king[0] > queen[0] && king[0] - queen[0] == queen[1] - king[1]) {
                if (rightUp.isEmpty()) {
                    rightUp.add(queen[0]);
                    rightUp.add(queen[1]);
                } else {
                    if (rightUp.get(0) < queen[0]) {
                        rightUp.set(0, queen[0]);
                        rightUp.set(1, queen[1]);
                    }
                }
                continue;
            }
            if (queen[0] == king[0] && queen[1] < king[1]) {
                left = Math.max(left, queen[1]);
                continue;
            }
            if (queen[0] == king[0] && queen[1] > king[1]) {
                right = Math.min(right, queen[1]);
                continue;
            }
            if (queen[1] == king[1] && queen[0] < king[0]) {
                up = Math.max(up, queen[0]);
                continue;
            }
            if (queen[1] == king[1] && queen[0] > king[0]) {
                down = Math.min(down, queen[0]);
            }
        }
        if (left != Integer.MIN_VALUE) {
            res.add(Arrays.asList(king[0], left));
        }
        if (right != Integer.MAX_VALUE) {
            res.add(Arrays.asList(king[0], right));
        }
        if (up != Integer.MIN_VALUE) {
            res.add(Arrays.asList(up, king[1]));
        }
        if (down != Integer.MAX_VALUE) {
            res.add(Arrays.asList(down, king[1]));
        }
        if (!leftDown.isEmpty()) {
            res.add(leftDown);
        }
        if (!leftUp.isEmpty()) {
            res.add(leftUp);
        }
        if (!rightDown.isEmpty()) {
            res.add(rightDown);
        }
        if (!rightUp.isEmpty()) {
            res.add(rightUp);
        }


        return res;
    }

}
