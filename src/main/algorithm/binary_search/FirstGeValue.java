package main.algorithm.binary_search;

public class FirstGeValue {

    public int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid-1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

}
