package main.algorithm.basic_sort;

public class InsertSort {

    public void insertSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j+1] = a[j];      //移动数据，左半部分是已经排序好的元素
                } else {
                    break;
                }
            }
            a[j+1] = value;     //插入正确的位置
        }
    }

}
