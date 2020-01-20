package main.classify.array;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = (start + end) / 2;
            int num = nums[index];
            if (num == target) {
                return index;
            } else if (num < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return start;

    }

}
