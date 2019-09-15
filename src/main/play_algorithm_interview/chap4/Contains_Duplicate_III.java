package main.play_algorithm_interview.chap4;

import java.util.Comparator;
import java.util.TreeSet;

public class Contains_Duplicate_III {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> records = new TreeSet<>(Comparator.naturalOrder());
        for (int i = 0; i < nums.length; i++) {

            Long floor = records.floor((long)nums[i] + (long) t);
            Long ceil = records.ceiling((long) nums[i] - (long) t);

            if (floor != null && floor >= nums[i] || ceil != null && ceil <= nums[i]) {
                return true;
            }


            records.add((long) nums[i]);
            if (records.size() == k+1) {
                records.remove((long)nums[i-k]);
            }
        }
        return false;
    }




    public static void main(String[] args) {
        Contains_Duplicate_III test = new Contains_Duplicate_III();
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{4, 1, 6, 3}, 100, 1));
    }
}
