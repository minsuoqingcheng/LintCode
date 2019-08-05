package main.algorithm.basic_sort;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] a, int n) {
        helper(a, 0, n-1);
    }


    private void helper(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);     //获取分区点
        helper(a, p, q-1);
        helper(a, q+1, r);

    }

    @SuppressWarnings("Duplicates")
    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {

                if (i == j) {
                    i++;
                } else {
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }

            }
        }

        int temp = a[i];
        a[i] = pivot;
        a[r] = temp;

        return i;
    }


    private int partition2(int[] a, int l, int r) {
        int v = a[l];

        //arr[l+1, j] < v
        //arr[j+1, i) > v 
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if (a[i] < v) {
                //交换 j+1 和 i
                int temp = a[j+1];
                a[j+1] = a[i];
                a[i] = temp;
                j++;
            }
        }

        int temp = a[l];
        a[l] = a[j];
        a[j] = temp;

        return j;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[]{8, 2, 10, 32, 7};
        quickSort.quickSort(a, 5);
        System.out.println(Arrays.toString(a));
    }
}
