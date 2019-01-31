package main.LeetCode.medium_1.question33;

public class Search_in_Rotated_Sorted_Array {


    public int search1(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[first] <= nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            }
        }
        return -1;
    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        //找到转折点
        while (low < high) {
            int middle = (low + high) / 2;
            if (nums[middle] > nums[high]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        int pivot = low;
        if (pivot == 0) {
            pivot = nums.length - 1;
        }
        if (target >= nums[0]) {
            low = 0;
            high = pivot;
            return binarySearch(nums, low, high, target);
        } else {
            low = pivot;
            high = nums.length - 1;
            return binarySearch(nums, low, high, target);
        }
    }


    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array test = new Search_in_Rotated_Sorted_Array();
        int[] nums = {1, 3};
        int res = test.search(nums, 3);
        System.out.println(res);
    }

}
