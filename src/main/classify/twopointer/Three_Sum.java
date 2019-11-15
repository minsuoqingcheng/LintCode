package main.classify.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low-1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high+1]) {
                        high--;
                    }
                }
            }
        }
        return res;
    }

}
