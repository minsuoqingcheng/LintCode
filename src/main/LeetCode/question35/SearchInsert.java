package main.LeetCode.question35;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[length-1]) {
            return length;
        }
        return 0;
    }

}
