package main.play_basic_algorithm.chap2;

/**
 * 选择排序
 * 从第一个位置开始依次选择最小的元素
 */
public class SelectionSort {

    public static void sort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        
    }


    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

}
