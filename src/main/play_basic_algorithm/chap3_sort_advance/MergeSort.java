package main.play_basic_algorithm.chap3_sort_advance;

import java.util.Arrays;

/**
 * 归并排序O(n logN)
 */
public class MergeSort {


    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }


    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        Comparable[] tmp = new Comparable[r-l+1];
        while (i <= mid && j <= r) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        //判断是否还有剩余元素
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = arr[start++];
        }
        //拷贝tmp到原数组
        for (int m = 0; m <= r-l; m++) {
            //原数组是从索引为l开始的
            arr[l+m] = tmp[m];
        }
    }

    public static void main(String[] args) {
        Integer[] test = new Integer[]{1, 5, 3, 9, 4};
        MergeSort.sort(test);
        System.out.println(Arrays.toString(test));
    }

}
