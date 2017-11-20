package main;

/**
 * Created by imccl on 2017/11/20.
 */
public class Question3 {

    /*
    * param k : As description.
    * param n : As description.
    * return: An integer denote the count of digit k in 1..n
    */
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        int base = 1;
        if (k==0 && n==0) {
            return 1;
        }
        while (n/base > 0) {
            int curBit = (n / base) % 10;
            int low = n - (n / base) * base;
            int high = n / (base * 10);
            if (curBit < k) {
                result += ((high - 1) + 1) * base;
            } else if (curBit == k) {
                result += ((high - 1) + 1) * base + low + 1;
            } else {
                //要排除高位是0的情况，是0-0的情况已在开始时给出返回值
                if (high == 0 && k == 0) {

                } else {
                    result += (high + 1) * base;
                }
            }
            base *= 10;
        }
        return result;
    }

}
