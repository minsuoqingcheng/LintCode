package main.LeetCode.easy_to_250.question231;

public class Power_of_Two {

    public boolean isPowerOfTwo(int n) {
        if(n<=0) {
            return false;
        }
        return (n&(n-1)) == 0;
    }

}
