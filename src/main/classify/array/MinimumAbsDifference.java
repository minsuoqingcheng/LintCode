package main.classify.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int minus = arr[i+1] - arr[i];
            if (minus < min) {
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i+1]));
                min = minus;
            }
            else if (minus == min) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return res;
    }

}
