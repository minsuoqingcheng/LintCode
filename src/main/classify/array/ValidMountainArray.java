package main.classify.array;

public class ValidMountainArray {


    public boolean validMountainArray2(int[] A) {
        int N = A.length;
        int i = 0;

        while (i+1 < N && A[i] < A[i+1]) {
            i++;
        }
        if (i == 0 || i == N-1) {
            return false;
        }
        while (i+1 < N && A[i] > A[i+1]) {
            i++;
        }
        return i == N-1;

    }

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int index = -1;
        //high
        if (A[0] > A[1]) {
            return false;
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i+1] == A[i]) {
                return false;
            } else if (A[i+1] < A[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        //low
        for (int i = index + 1; i < A.length - 1; i++) {
            if (A[i] <= A[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidMountainArray test = new ValidMountainArray();
        System.out.println(test.validMountainArray(new int[]{3,7,6,4,3,0,1,0}));
    }

}
