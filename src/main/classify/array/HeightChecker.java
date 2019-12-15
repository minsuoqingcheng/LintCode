package main.classify.array;

import java.util.Arrays;

/**
 * 找出没有站对位置的学生
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {

        int[] clone = heights.clone();
        Arrays.sort(clone);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (clone[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

}
