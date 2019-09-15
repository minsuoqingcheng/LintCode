package main.play_algorithm_interview.chap10;

import java.util.Arrays;

public class Non_Overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        sortStart(intervals);
        //memo[i]表示从[0...i]的区间构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        memo[0] = 1;

        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    memo[i] = Math.max(memo[i], memo[j]+1);
                }
            }
            res = Math.max(res, memo[i]);
        }

        return intervals.length - res;
    }


    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {
                res++;
                pre = i;
            }
        }
        return intervals.length - res;
    }


    private void sortStart(int[][] intervals) {
        int length = intervals.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (intervals[j][0] < intervals[i][0] ||
                        (intervals[j][0] == intervals[i][0] && intervals[j][1] < intervals[i][1])) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        Non_Overlapping_Intervals test = new Non_Overlapping_Intervals();
        int[][] array = new int[][]{{1,2}, {3,4}, {2,3}};
        test.sortStart(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][0] + " " + array[i][1]);
        }
    }



}
