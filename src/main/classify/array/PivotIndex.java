package main.classify.array;

public class PivotIndex {


    /**
     * 公式：
     *  leftSum + nums[i] + rightSum = sum
     *  leftSum = rightSum
     * 求出sum，每次更新leftSum3，使用减法，减少一次循环
     * @param nums
     * @return
     */
    public int pivotIndex2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (sum - nums[i] - leftSum)) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }




    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int leftSum = sum(nums, 0, i-1);
            int rightSum = sum(nums, i+1, length-1);
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }


    private int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
