package main.play_basic_algorithm.chap3;

import java.util.Arrays;

/**
 * 3路快速排序
 */
public class QuickSort3Way {


    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );
        Comparable v = arr[l];

        int lt = l;         //arr[l+1...lt] < v
        int gt = r + 1;     //arr[gt...r] > v
        int i = l + 1;      //arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt+1);     //交换的是等于v的元素，i可以++，直接处理下一个元素
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt-1);     //交换的是不知道大小的元素，所以i不可以++，需要继续处理
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, l, lt);
        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        Integer[] test = new Integer[]{1, 5, 3, 9, 4};
        QuickSort3Way.sort(test);
        System.out.println(Arrays.toString(test));
    }

}
