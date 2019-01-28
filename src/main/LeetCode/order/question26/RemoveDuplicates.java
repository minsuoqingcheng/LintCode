package main.LeetCode.order.question26;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int count = 0;
        int length = nums.length;
        if (length == 0) {
            return count;
        }
        int compare = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != compare) {
                count++;
                compare = nums[i];
                if (count != i) {
                    nums[count] = compare;
                }

            }
        }
        return count+1;
    }

}
