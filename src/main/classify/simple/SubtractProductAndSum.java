package main.classify.simple;

public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n != 0) {
            int remainder = n % 10;
            sum += remainder;
            product *= remainder;
            n /= 10;
        }
        return product - sum;
    }

}
