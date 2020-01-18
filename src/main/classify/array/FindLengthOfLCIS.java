package main.classify.array;

public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int max = 1;
        int current = 1;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i+1] > nums[i]) {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                current = 1;
            }
        }
        return Math.max(current, max);
    }

}
