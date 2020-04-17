package main.classify.everyday;

public class CanJump {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i+nums[i]);
            }
        }
        return max >= nums.length-1;
    }

}
