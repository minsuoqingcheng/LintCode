package main;

/**
 * Created by imccl on 2017/11/19.
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 * 关键点：异或 + 进位
 */
public class Question1 {

    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb1(int a, int b) {
        // write your code here
        int addResult = a ^ b;
        int carry = a & b;
        if (carry != 0) {
            carry = carry << 1;
            addResult = aplusb1(addResult, carry);
        }
        return addResult;
    }

    //better
    public int aplusb2(int a, int b) {
        do {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        } while (b != 0);
        return a;
    }

}
