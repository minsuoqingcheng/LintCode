package main.play_basic_algorithm.chap2_basic_sort;

/**
 * 冒泡排序 优化
 */
public class BubbleSort2 {

    public static void srot(Comparable[] arr) {
        int n = arr.length;
        int newn;

        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i-1].compareTo(arr[i]) > 0) {
                    swap(arr, i-1, i);
                    // 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
                    newn = i;
                }
            }
            n = newn;
        } while (newn > 0);
    }

    private static void swap(Object[] arr, int i, int j) {
        if (i != j) {
            Object temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

}
