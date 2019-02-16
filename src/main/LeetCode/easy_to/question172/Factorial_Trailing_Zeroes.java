package main.LeetCode.easy_to.question172;

public class Factorial_Trailing_Zeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        for (long i = 0; i <= n; i += 5) {
            if (i > 0 && i % 5 == 0) {
                count += getFiveCount(i);
            }
        }
        return count;
    }


    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 4) {
            n /= 5;
            count += n;
        }
        return count;
    }


    private int getFiveCount(long number) {
        int count = 0;
        while (number % 5 == 0 && number != 0) {
            count++;
            number = number / 5;
        }
        return count;
    }


    public static void main(String[] args) {
        Factorial_Trailing_Zeroes test = new Factorial_Trailing_Zeroes();
        System.out.println(test.trailingZeroes(2147483647));
    }

}
