package main.classify.everyday;

public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {

        int[] cnt = new int[nums.length+1];
        int odd = 0;
        int ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            odd += nums[i] & 1;
            cnt[odd]++;
            if (odd >= k) {
                ans += cnt[odd-k];
            }
        }
        return ans;
    }

}
