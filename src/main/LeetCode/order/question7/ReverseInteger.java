package main.LeetCode.order.question7;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        List<Integer> numbers = new ArrayList<>();
        long result = 0;
        int base = 10;
        while (x % base == 0) {
            x = x / base;
        }
        while (x / base != 0) {
            numbers.add(x % base);
            x = x / 10;
        }
        numbers.add(x);
        for (int i = 0; i < numbers.size(); i++) {
            long multi = (long) Math.pow(base, numbers.size()-1-i);
            result += numbers.get(i) * multi;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }

    public int reverse2(int x) {
        long result=0;
        while(x!=0)
        {
            int mod = x%10;
            result = result * 10 + mod;
            if(result > 0x7fffffff || result < -0x7fffffff)
            {
                result = 0 ;
                break;
            }
            x= x/10;
        }
        return (int)result;
    }


    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(-2147483648);
        System.out.println(result);
    }

}
