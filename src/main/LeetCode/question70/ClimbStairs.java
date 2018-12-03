package main.LeetCode.question70;

public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbStairs test = new ClimbStairs();
        System.out.println(test.climbStairs(44));
    }

}
