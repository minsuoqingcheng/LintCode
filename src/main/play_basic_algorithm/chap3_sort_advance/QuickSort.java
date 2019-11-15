package main.play_basic_algorithm.chap3_sort_advance;

import java.util.Arrays;

/**
 * 快速排序 O(N logN)
 */
public class QuickSort {


    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length-1);
    }


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        int pivot = (int)(Math.random()*(r-l+1))+l;
        swap(arr, l, pivot);

        Comparable e = arr[l];
        int j = l;  //// arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l+1; i <= r; i++) {
            if (e.compareTo(arr[i]) > 0) {
                j++;
                swap(arr, j, i);
            }
        }

        swap(arr, l, j);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        Integer[] test = new Integer[]{1, 5, 3, 9, 4};
        QuickSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
