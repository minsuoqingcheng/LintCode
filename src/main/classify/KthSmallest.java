package main.classify;

public class KthSmallest {

    public int kthSmallest(int[] a, int k) {
        if (a == null || a.length < k) {
            return -1;
        }
        int q = partition(a, 0, a.length-1);
        while (q + 1 != k) {
            if (q + 1 < k) {
                q = partition(a, q+1, a.length-1);
            } else {
                q = partition(a, 0, q-1);
            }
        }
        return a[q];
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


    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(new int[]{1, 4, 10, 3}, 2));
    }
}
