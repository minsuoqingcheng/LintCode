package main.LeetCode.medium_1.question34;

import java.util.Arrays;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = nums[middle];
            if (middleValue > target) {
                right = middle - 1;
            }
            if (middleValue < target) {
                left = middle + 1;
            }
            if (middleValue == target) {
                if (middle > 0 && nums[middle-1] < target || middle == 0) {
                    return middle;
                } else {
                    right = middle;
                }

            }
        }
        return -1;
    }


    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = nums[middle];
            if (middleValue > target) {
                right = middle - 1;
            }
            if (middleValue < target) {
                left = middle + 1;
            }
            if (middleValue == target) {
                if (middle < nums.length - 1 && nums[middle+1] > target || middle == nums.length - 1) {
                    return middle;
                } else {
                    left = middle + 1;
                }

            }
        }
        return -1;
    }



    public int findFirst(int[] nums, int target){
        int index = -1, start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >=  target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }

    public int findSecond(int[] nums, int target){
        int index = -1, start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <=  target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        Find_First_and_Last_Position_of_Element_in_Sorted_Array test = new Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int[] res = test.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(Arrays.toString(res));
    }

}
