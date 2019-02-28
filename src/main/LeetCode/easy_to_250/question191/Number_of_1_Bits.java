package main.LeetCode.easy_to_250.question191;

public class Number_of_1_Bits {

    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

}
