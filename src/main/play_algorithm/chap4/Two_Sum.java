package main.play_algorithm.chap4;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int completeNum = target - nums[i];
            Integer index;
            if ((index = record.get(completeNum)) != null) {
                return new int[]{index, i};
            } else {
                record.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};

    }

}
