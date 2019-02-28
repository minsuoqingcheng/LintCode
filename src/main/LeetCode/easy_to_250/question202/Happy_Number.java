package main.LeetCode.easy_to_250.question202;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {

    public boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.add(n)) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }

}
