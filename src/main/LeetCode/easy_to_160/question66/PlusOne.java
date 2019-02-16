package main.LeetCode.easy_to_160.question66;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i >= 0; i--) {
            int pulsRes = digits[i] + 1;
            if (pulsRes < 10) {
                digits[i] = pulsRes;
                return digits;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int[] res = Arrays.copyOf(digits, length+1);
                    res[0] = 1;
                    return res;
                }
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        System.out.println(Arrays.toString(test.plusOne(new int[]{1, 9, 9})));
    }

}
