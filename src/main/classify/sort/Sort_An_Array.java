package main.classify.sort;

public class Sort_An_Array {

    public int[] sortArray(int[] nums) {
        helper(nums, 0, nums.length-1);
        return nums;
    }

    private void helper(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        helper(a, p, q-1);
        helper(a, q+1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {

            //如果小于看看需不需要替换
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
}
