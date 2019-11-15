package main.classify.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            threeSum(nums, i+1, n-1, target-nums[i], results);
        }
        return results;
    }


    private void threeSum(int[] nums, int low, int high, int target, List<List<Integer>> results) {

        for (int i = low; i <= high; i++) {
            if (i > low && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = high;
            int subTarget = target - nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < subTarget) {
                    j++;
                } else if (sum > subTarget) {
                    k--;
                } else {
                    results.add(Arrays.asList(nums[low-1], nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
        }
    }
}
