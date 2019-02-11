package main.LeetCode.medium_1.question39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] dp = new ArrayList[target+1];

        for (int t = 0; t <= target; t++) {
            List<List<Integer>> comList = new ArrayList<>();
            for (int j = 0; j < candidates.length && candidates[j] <= t; j++) {
                if (candidates[j] == t) {
                    comList.add(Collections.singletonList(t));
                } else {
                    for (List<Integer> prevList : dp[t-candidates[j]]) {
                        if (candidates[j] >= prevList.get(prevList.size() - 1)) {
                            List<Integer> temp = new ArrayList(prevList);
                            temp.add(candidates[j]);
                            comList.add(temp);
                        }
                    }
                }
            }
            dp[t] = comList;
        }

        return dp[target];
    }

}
