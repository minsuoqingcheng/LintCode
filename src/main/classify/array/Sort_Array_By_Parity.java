package main.classify.array;

public class Sort_Array_By_Parity {

    public int[] sortArrayByParity(int[] A) {
        int[] array = new int[A.length];
        int evenIndex = 0;
        int oddIndex = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                array[evenIndex++] = A[i];
            } else {
                array[oddIndex--] = A[i];
            }
        }
        return array;
    }

}
