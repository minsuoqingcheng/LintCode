package main.classify.dp;

public class Climbing_Stairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = f1 + f2;
            f1 = f2;
            f2 = current;
        }
        return f2;
    }

}
