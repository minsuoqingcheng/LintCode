package main.classify.array;

public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int[] arr = A[i];
            int length = arr.length;
            for (int j = 0; j < length / 2; j++) {
                int temp = arr[j];
                arr[j] = arr[length-1-j];
                arr[length-1-j] = temp;
            }
            for (int j = 0; j < length; j++) {
                if (arr[j] == 0) {
                    arr[j] = 1;
                    continue;
                }
                if (arr[j] == 1) {
                    arr[j] = 0;
                }

            }
        }
        return A;
    }

}
