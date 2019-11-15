package main.classify.math;

public class Reverse_Integer {

    public int reverse(int x) {
        long r = 0;
        while(x != 0) {
            r = 10 * r + x % 10;
            x = x / 10;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) r;
        }
    }

}
