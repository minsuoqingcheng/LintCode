package main.recruit.qiuzhao.yitu;

import java.util.*;

public class Question2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int edge = scanner.nextInt();
        int caseCount = scanner.nextInt();
        int[][] matrix = new int[edge][edge];
        boolean[][] flag = new boolean[edge][edge];
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < caseCount; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            //x,y代表开始位置
            int x = edge - m;
            int y = n - 1;
            if (matrix[x][y] == -1) {
                System.out.println("empty!");
                continue;
            }
            Map<Integer, Integer> points = samePoints(matrix, x, y, flag);
            if (points.isEmpty()) {
                flag[x][y] = false;
                System.out.println("only one!");
                continue;
            }
            //根据flag计算数量
            int sameCount = compute(flag);
            System.out.println(sameCount);
            //更新数组
            update(matrix, flag);
            //重置flag
            reset(flag);
        }
    }




    private static Map<Integer, Integer> samePoints(int[][] matrix, int x, int y, boolean[][] flag) {
        flag[x][y] = true;
        Map<Integer, Integer> points = new HashMap<>();
        int value = matrix[x][y];
        if (x - 1 >= 0) {
            //左
            if (matrix[x-1][y] == value && !flag[x-1][y]) {
                points.put(x-1, y);
                flag[x-1][y] = true;
                samePoints(matrix, x-1, y, flag);
            }
        }
        if (x + 1 < matrix.length) {
            //右
            if (matrix[x+1][y] == value && !flag[x+1][y]) {
                points.put(x+1, y);
                flag[x+1][y] = true;
                samePoints(matrix, x+1, y, flag);
            }
        }
        if (y - 1 >= 0) {
            //下
            if (matrix[x][y-1] == value && !flag[x][y-1]) {
                points.put(x, y-1);
                flag[x][y-1] = true;
                samePoints(matrix, x, y-1, flag);
            }
        }
        if (y + 1 < matrix.length) {
            //上
            if (matrix[x][y+1] == value && !flag[x][y+1]) {
                points.put(x, y+1);
                flag[x][y+1] = true;
                samePoints(matrix, x, y+1, flag);
            }
        }
        return points;
    }


    private static void reset(boolean[][] flag) {
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i], false);
        }
    }

    private static int compute(boolean[][] flag) {
        int count = 0;
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag.length; j++) {
                if (flag[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void update(int[][] matrix, boolean[][] flag) {
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag.length; j++) {
                if (flag[i][j]) {
                    matrix[i][j] = -1;
                }
            }
        }
        //空的列
        List<Integer> emptyColumn = new ArrayList<>();
        //更新列
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] != -1) {
                    temp.add(matrix[j][i]);
                }
            }
            if (temp.isEmpty()) {
                emptyColumn.add(i);
            } else if (temp.size() < matrix.length) {
                int leftCount = temp.size();
                int removeCount = matrix.length - leftCount;
                for (int j = 0; j < removeCount; j++) {
                    matrix[j][i] = -1;
                }
                for (int j = 0; j < leftCount; j++) {
                    matrix[removeCount+j][i] = temp.get(j);
                }
            }
        }
        //移动列
        for (int i = 0; i < emptyColumn.size(); i++) {
            int columnIndex = emptyColumn.get(i);
            for (int j = columnIndex + 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    matrix[k][j-1] = matrix[k][j];
                }
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length-1] = -1;
            }
        }
    }
}
