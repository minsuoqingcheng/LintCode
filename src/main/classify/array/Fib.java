package main.classify.array;

public class Fib {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int zero = 0;
        int first = 1;
        for (int i = 2; i <= N; i++) {
            int temp = first + zero;
            zero = first;
            first = temp;
        }
        return first;
    }

}
