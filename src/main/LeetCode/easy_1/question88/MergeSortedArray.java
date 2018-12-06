package main.LeetCode.easy_1.question88;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {

    /**
     * 要利用num1的空余空间
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void goodMerge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        m--; n--;
        while (m >= 0 && n >= 0){
            if (nums1[m] > nums2[n]) nums1[i] = nums1[m--];
            else nums1[i] = nums2[n--];
            i--;
        }
        while (m >= 0 && i >= 0){
            nums1[i--] = nums1[m--];
        }
        while (n >= 0 && i >= 0){
            nums1[i--] = nums2[n--];
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstIndex = 0;
        int secondIndex = 0;
        int total = m + n;
        List<Integer> sorted = new ArrayList<>(m+n);
        while (firstIndex < m && secondIndex < n) {
            int first = nums1[firstIndex];
            int second = nums2[secondIndex];
            if (first < second) {
                sorted.add(first);
                firstIndex++;
            } else {
                sorted.add(second);
                secondIndex++;
            }
        }
        while (firstIndex < m) {
            sorted.add(nums1[firstIndex]);
            firstIndex++;
        }
        while (secondIndex < n) {
            sorted.add(nums2[secondIndex]);
            secondIndex++;
        }
        for (int i = 0; i < total; i++) {
            nums1[i] = sorted.get(i);
        }
    }


    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();
        test.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

}
