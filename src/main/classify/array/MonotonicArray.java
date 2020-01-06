package main.classify.array;

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean gt = false;
        boolean lt = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i+1]) {
                lt = true;
            } else if (A[i] > A[i+1]) {
                gt = true;
            }
            if (lt && gt) {
                return false;
            }
        }
        return true;
    }

}
