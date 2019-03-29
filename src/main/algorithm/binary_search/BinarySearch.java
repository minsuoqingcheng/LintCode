package main.algorithm.binary_search;

public class BinarySearch {

    /**
     * 非递归实现
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);    //这边需要注意符号的优先级
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 递归实现
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int binarySearchRecursionly(int[] a, int n, int value) {
        return helper(a, 0, n-1, value);
    }


    private int helper(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 2);        //这边需要注意符号的优先级
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return helper(a, mid+1, high, value);
        } else {
            return helper(a, low, mid-1, value);
        }
    }

}
