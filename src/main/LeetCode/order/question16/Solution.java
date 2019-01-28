package main.LeetCode.order.question16;

import java.util.Arrays;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = nums[0] + nums[1] + nums[length-1];
        for (int i = 0; i < length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
                if (Math.abs(sum-target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.threeSumClosest(new int[]{1,2,5,10,11}, 12);
        System.out.println(res);
        int res2 = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(res2);
    }
}