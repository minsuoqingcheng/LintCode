package main.LeetCode.esay_to.question268;

public class Missing_Number {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (1+length) * length / 2;
        for (int i = 0; i < length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

}
