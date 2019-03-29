package main.algorithm.basic_sort;

import java.util.Arrays;

/**
 * 计数排序适用于数据范围不大的场景，且只能给非负整数排序
 * 如果出现小数，可以乘以10
 * 如果出现负数，可以加上某个数变为正整数
 */
public class CountSort {

    public void countSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int[] c = new int[max+1];     //映射：元素——>位置
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i-1] + c[i];
        }

        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }


    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] a = new int[]{1, 16, 9, 10};
        countSort.countSort(a, 4);
        System.out.println(Arrays.toString(a));
    }

}
