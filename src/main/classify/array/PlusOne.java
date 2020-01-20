package main.classify.array;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 1) {
                digits[i] = digits[i] + carry;
                carry = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
        }
        if (carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i-1];
            }
            return res;
        } else {
            return digits;
        }
    }

}
