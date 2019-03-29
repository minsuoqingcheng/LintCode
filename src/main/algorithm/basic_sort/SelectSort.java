package main.algorithm.basic_sort;

public class SelectSort {

    public void selectSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            //查找最小值
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
               if (a[j] < a[minIndex]) {
                   minIndex = j;
               }
            }
            //交换
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;

        }

    }

}
