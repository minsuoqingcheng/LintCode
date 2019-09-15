package main.play_algorithm_interview.chap4;

import java.util.HashMap;
import java.util.Map;

public class FourSum_II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> record = new HashMap<>();
        for (int aC : C) {
            for (int aD : D) {
                int sum = aC + aD;
                int times = record.getOrDefault(sum, 0);
                times++;
                record.put(sum, times);
            }
        }

        int ans = 0;
        for (int aA : A) {
            for (int aB: B) {
                ans += record.getOrDefault(0 - aA - aB, 0);
            }
        }

        return ans;
    }

}
