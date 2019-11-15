package main.play_basic_algorithm.chap2_basic_sort;

/**
 * 选择排序优化
 * 每次选择的时候找出最小值和最大值
 */
public class SelectionSort2 {

    public static void sort(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            //在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, minIndex, maxIndex);
            }

            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                }
                if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
        }
    }


    private static void swap(Object[] arr, int i, int j) {
        if (i != j) {
            Object temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

}
