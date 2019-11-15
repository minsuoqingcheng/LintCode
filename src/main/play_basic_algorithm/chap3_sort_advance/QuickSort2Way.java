package main.play_basic_algorithm.chap3_sort_advance;

import java.util.Arrays;

/**
 * 双路快速排序
 */
public class QuickSort2Way {


    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }


    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        int pivot = (int)(Math.random()*(r-l+1))+l;
        swap(arr, l, pivot);

        int i = l + 1;  //arr[l+1, i) <= v
        int j = r;      //arr(j, r] >= v

        Comparable v = arr[l];
        while (true) {

            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j >= l+1 && arr[j].compareTo(v) > 0) {
                j--;
            }

            if (i > j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
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
        QuickSort2Way.sort(test);
        System.out.println(Arrays.toString(test));
    }
}


