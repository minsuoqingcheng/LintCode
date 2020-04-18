package main.classify.simple;

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j != i && nums[i] > nums[j]) {
                    count[i]++;
                }
            }
        }
        return count;
    }

}
