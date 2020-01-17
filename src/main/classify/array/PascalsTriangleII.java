package main.classify.array;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex+1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for (int i = 1; i < rowIndex+1; i++) {
            /**
             * [1] -> [1, 0] -> [1, 1]
             * [1, 1, 0] -> [1, 2, 1]
             * [1, 2, 1, 0] -> [1, 3, 3, 1]
             * [1, 3, 3, 1, 0] -> [1, 4, 6, 4, 1]
             * ......
             */
            for (int j = i; j >= 1; j--) {
                result[j] += result[j-1];
            }
        }
        return Arrays.asList(result);
    }

}
