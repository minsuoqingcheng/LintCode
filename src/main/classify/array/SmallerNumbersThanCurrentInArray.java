package main.classify.array;

public class SmallerNumbersThanCurrentInArray {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int[] cnt = new int[101];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
        }

        for (int i = 1; i < 101; i++) {
            cnt[i] += cnt[i-1];
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = cnt[nums[i]-1];
            }

        }
        return result;
    }
}
