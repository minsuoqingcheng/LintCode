package main.recruit.qiuzhao.xiaohongshu;

import java.util.*;

public class Question1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int edge = scanner.nextInt();
        int[][] matrix = new int[edge][edge];
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        boolean[][] flag = new boolean[edge][edge];
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                if (flag[i][j] || matrix[i][j] == 0) {
                    continue;
                }
                flag[i][j] = true;
                Map<Integer, Integer> points = compute(matrix, i, j, edge, flag);
                while (!points.isEmpty()) {
                    Map<Integer, Integer> newPoints = new HashMap<>();
                    Set<Map.Entry<Integer, Integer>> entries = points.entrySet();
                    entries.forEach(e -> {
                        int x = e.getKey();
                        int y = e.getValue();
                        flag[x][y] = true;
                        newPoints.putAll(compute(matrix, x, y, edge, flag));
                    });
                    points = newPoints;
                }
                count++;
            }
        }
        System.out.println(count);
    }


    private static Map<Integer, Integer> compute(int[][] matrix, int x, int y, int edge, boolean[][] flag) {
        Map<Integer, Integer> points = new HashMap<>();
        if (x - 1 > 0 && matrix[x-1][y] == 1 && !flag[x-1][y]) {
            points.put(x-1, y);
        }
        if (x + 1 < edge && matrix[x+1][y] == 1 && !flag[x+1][y]) {
            points.put(x+1, y);
        }
        if (y - 1 > 0 && matrix[x][y-1] == 1 && !flag[x][y-1]) {
            points.put(x, y-1);
        }
        if (y + 1 < edge && matrix[x][y+1] == 1 && !flag[x][y+1]) {
            points.put(x, y+1);
        }
        return points;
    }

}
