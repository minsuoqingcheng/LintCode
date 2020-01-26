package main.classify.array;

import java.util.*;

public class FindPairs {


    public int findPairs2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> num2count = new HashMap<>();
        for (int num : nums) {
            num2count.put(num, num2count.getOrDefault(num, 0)+1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : num2count.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (num2count.containsKey(entry.getKey()+k)) {
                    count++;
                }
            }
        }
        return count;

    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int length = nums.length;
        Set<Integer> begin = new HashSet<>();
        while (i < length - 1) {
            int current = nums[i];
            if (begin.contains(current)) {
                i++;
                continue;
            }
            for (int j = i+1; j < length; j++) {
                int interval = nums[j] - current;
                if (interval == k) {
                    begin.add(current);
                    count++;
                    break;
                } else if (interval > k) {
                    break;
                }
            }

            i++;
        }
        return count;
    }

}
