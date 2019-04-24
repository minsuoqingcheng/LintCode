package main.classify.dp;

public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = min;
            min = Math.min(Math.min(max*nums[i], min*nums[i]), nums[i]);
            max = Math.max(Math.max(max*nums[i], temp*nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

}
