package main.play_basic_algorithm.chap2_basic_sort;

/**
 * 插入排序
 * 将每一个元素插入到合适的位置
 */
public class InsertionSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {

            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                swap(arr, j, j-1);
            }
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
