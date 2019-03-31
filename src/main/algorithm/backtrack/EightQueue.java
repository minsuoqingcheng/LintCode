package main.algorithm.backtrack;

/**
 * 8皇后问题：找到所有符合条件的棋子排放顺序
 *
 * 回溯的处理思想，有点类似于枚举搜索，我们枚举所有可能的解
 * 如果不符合条件就返回上一层
 *
 */
public class EightQueue {

    private int[] result = new int[8];

    public void callEightQueue(int row) {
        if (row == 8) {
            printQueues();
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOK(row, column)) {
                result[row] = column;
                callEightQueue(row+1);
            }
        }
    }


    private boolean isOK(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    return false;
                }
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }


    private void printQueues() {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("=======================");
    }


    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue();
        eightQueue.callEightQueue(0);
    }

}
