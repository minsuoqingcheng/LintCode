package main.algorithm.basic_sort;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] a, int n) {
        helper(a, 0, n-1);
    }

    private void helper(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = p + (r- p) / 2;
        helper(a, p, q);
        helper(a, q+1, r);


        merge(a, p, q, r);
//        if (a[q] > a[q+1]) {    //这种情况才需要merge
//
//        }
    }


    private void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r-p+1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        //判断是否还有剩余元素没有拷贝
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        //将tmp拷贝到原数组
        for (int l = 0; l <= r-p; l++) {
            a[p+l] = tmp[l];
        }
        
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{1, 3, 2, 9,  5, 8, 6, 4};
        mergeSort.mergeSort(a, 8);
        System.out.println(Arrays.toString(a));
    }
}
