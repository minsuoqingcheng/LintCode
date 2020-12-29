package main.classify.devideandconquer;

public class MyPow {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MIN_VALUE + 1;
                return 1 / (myPow(x, -n) * x);
            } else {
                return 1 / myPow(x, -n);
            }

        }

        if (n % 2 == 0) {
            return myPow(x*x, n/2);
        } else {
            return x * myPow(x, n-1);
        }

    }

    public double myPow2(double x, int n) {

        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }

        return n >= 0 ? res : 1 / res;
    }


    public static void main(String[] args) {
        MyPow test = new MyPow();
        System.out.println(test.myPow(2, -2));
    }

}
