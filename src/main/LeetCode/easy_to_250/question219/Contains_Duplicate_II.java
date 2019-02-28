package main.LeetCode.easy_to_250.question219;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        List<Integer> distinct = new ArrayList<>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (distinct.contains(nums[i])) {
                return true;
            } else {
                distinct.add(nums[i]);
            }
        }
        for (int i = k+1; i < nums.length; i++) {
            distinct.remove(0);
            if (distinct.contains(nums[i])) {
                return true;
            } else {
                distinct.add(nums[i]);
            }
        }
        return false;
    }


    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Contains_Duplicate_II test = new Contains_Duplicate_II();
        test.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
    }
}
