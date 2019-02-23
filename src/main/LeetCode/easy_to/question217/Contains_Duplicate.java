package main.LeetCode.easy_to.question217;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!distinct.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
