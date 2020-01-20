package main.classify.array;

public class DominantIndex {

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxInde = -1;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxInde = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (max >= secondMax * 2) {
            return maxInde;
        } else {
            return -1;
        }
    }

}
