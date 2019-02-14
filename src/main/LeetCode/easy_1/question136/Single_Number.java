package main.LeetCode.easy_1.question136;

public class Single_Number {

    public int singleNumber(int[] nums) {
        int length = nums.length;
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

}
