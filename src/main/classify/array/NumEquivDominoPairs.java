package main.classify.array;

import java.util.HashMap;
import java.util.Map;

public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> num2count = new HashMap<>();
        int res = 0;
        for (int[] domin : dominoes) {
            int num = Math.min(domin[0], domin[1]) * 10 + Math.max(domin[0], domin[1]);
            num2count.put(num, num2count.getOrDefault(num, 0) + 1);
        }
        for (int count : num2count.values()) {
            res += count * (count - 1) / 2;
        }
        return res;
    }

}
