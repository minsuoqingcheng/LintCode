package main.classify.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));

        List<int[]> res = new ArrayList<>(intervals.length);
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] max = res.get(res.size()-1);
            if (intervals[i][0] > max[1]) {
                res.add(intervals[i]);
            } else {
                max[1] = Math.max(max[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}
