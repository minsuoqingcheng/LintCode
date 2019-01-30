package main.LeetCode.medium_1.question31;

public class Next_Permutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            int turn = nums[i];
            while (nums[j] <= turn) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }


    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i , j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
