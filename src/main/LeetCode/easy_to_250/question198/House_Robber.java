package main.LeetCode.easy_to_250.question198;

public class House_Robber {

    //可以通过不断的优化得到这个结果
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }


}
