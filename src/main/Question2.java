package main;

/**
 * Created by imccl on 2017/11/19.
 * 设计一个算法，计算出n阶乘中尾部零的个数
 * 关键点：以5为中心
 */
public class Question2 {

    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long result = 0;
        long factor;
        for(int i = 1; (factor = (long) Math.pow(5, i)) <= n; i++) {
            result += n / factor;
        }
        return result;
    }

}
