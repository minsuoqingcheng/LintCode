package main.classify.binarysearch;

public class Peak_Index_in_a_Mountain_Array {

    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int half = (left + right) / 2;
            if (half == A.length - 1 || half == 0) {
                break;
            }
            if (A[half] > A[half-1]) {
                if (A[half] > A[half+1]) {
                    return half;
                } else {
                    left = half + 1;
                }
            } else {
                right = half - 1;
            }
        }
        return -1;
    }

}
