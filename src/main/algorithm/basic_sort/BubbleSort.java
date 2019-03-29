package main.algorithm.basic_sort;

public class BubbleSort {

    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean swap = false;   //提前退出冒泡排序的标志，没有原始交换代表冒泡排序接收

            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }
    }

}
