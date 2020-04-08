package main.classify.array;

public class FindNumbersWithEven {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int length = 1;
            while (num / 10 != 0) {
                num = num / 10;
                length++;
            }
            if (length % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
