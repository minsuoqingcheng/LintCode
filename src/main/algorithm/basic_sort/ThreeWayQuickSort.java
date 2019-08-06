package main.algorithm.basic_sort;

import java.util.Arrays;

/**
 * 快速排序存在的两种问题：
 * 几乎有序的情况：O(n*n); 解法：随机挑选一个元素
 * 重复元素很多：O(n*n); 解法1：分为 >= 和 <= | 解法2：3路快排，分为 > < 和 =
 */
public class ThreeWayQuickSort {

    public void quickSort(int[] a, int n) {
        help(a, 0, n-1);
    }


    /**
     * 将a[l...r]分为3部分，<v; ==v; >v;3部分
     * 之后再递归的对<v 和 >v的部分排序
     * @param a
     * @param l
     * @param r
     */
    private void help(int[] a, int l, int r) {
        int lt = l;     //a[l+1, lt] < v
        int gt = r+1;   //a[gt, r] > v
        int i = l+1;    //a[lt+1, i) == v
        int v = a[l];
        while (i < gt) {
            if (a[i] < v) {
                swap(a, lt+1, i);
                i++;
                lt++;
            } else if (a[i] > v){
                swap(a, i, gt-1);
                gt--;
            } else {
                i++;
            }
        }

        swap(a, l, lt);
        help(a, l, lt-1);
        help(a, gt, r);
    }


    private void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }



    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = new int[]{8, 2, 10, 32, 7};
        quickSort.quickSort(a, 5);
        System.out.println(Arrays.toString(a));
    }
}
