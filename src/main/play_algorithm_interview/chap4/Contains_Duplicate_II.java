package main.play_algorithm_interview.chap4;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> records = new HashSet<>(k+1);
        for (int i = 0; i < nums.length; i++) {
            if (records.contains(nums[i])) {
                return true;
            }
            records.add(nums[i]);
            if (records.size() == k+1) {
                records.remove(nums[i-k]);
            }
        }
        return false;

    }

}
