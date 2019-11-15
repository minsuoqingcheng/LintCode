package main.play_basic_algorithm.chap2_basic_sort;

import java.util.Arrays;

/**
 * shell排序
 * 分组进行插入排序
 * 每一次遍历时分组中的数据是从小到大排好序的
 * 每一轮减小gap
 */
public class ShellSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j-h]) < 0; j -= h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = e;
            }

            h = h / 3;
        }
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 2, 5, 20, 9, 11, 15, 8, 7, 4};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
