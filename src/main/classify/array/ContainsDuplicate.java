package main.classify.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Set<Integer> array = new HashSet<>();
        for (int num : nums) {
            boolean result = array.add(num);
            if (!result) {
                return true;
            }
        }
        return false;
    }

}
