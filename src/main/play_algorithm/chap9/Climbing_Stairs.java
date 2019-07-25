package main.play_algorithm.chap9;

public class Climbing_Stairs {


    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

}
