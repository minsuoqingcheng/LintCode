package main.classify.dp;

public class Min_Cost_Climbing_Stairs {

    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0;     //n-1
        int f2 = 0;     //n-2
        int result = 0;
        for (int i = 2; i <= cost.length ; i++) {
            result = Math.min(f1+cost[i-1], f2+cost[i-2]);
            f2 = f1;
            f1 = result;

        }
        return result;
    }

}
