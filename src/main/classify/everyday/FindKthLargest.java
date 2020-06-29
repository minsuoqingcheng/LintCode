package main.classify.everyday;

import java.util.Random;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int targetIndex = length - k;
        int low = 0;
        int high = length - 1;
        while (true) {
            int i = partition(nums, low, high);
            if (i == targetIndex) {
                return nums[i];
            } else if (i < targetIndex) {
                low = i + 1;
            } else {
                high = i - 1;
            }
        }
    }

    private int partition(int[] nums, int low, int high) {
        if (high > low) {
            int random = low + new Random().nextInt(high - low);
            swap(nums, high, random);
        }
        int i = low;
        int pivot = nums[high];
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
