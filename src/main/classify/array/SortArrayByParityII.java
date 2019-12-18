package main.classify.array;

public class SortArrayByParityII {


    /**
     * Read and Write Head
     * @param A
     * @return
     */
    public int[] betterSortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i+= 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }


    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if ((i % 2 == 0 && A[i] % 2 == 0) || (i % 2 == 1 && A[i] % 2 ==1)) {
                continue;
            }
            if (i % 2 == 0) {
                for (int j = i+1; j < length; j++) {
                    if (A[j] % 2 == 0) {
                        swap(A, i, j);
                        i++;
                        break;
                    }
                }
                continue;
            }
            if (i % 2 == 1) {
                for (int j = i+1; j < length; j++) {
                    if (A[j] % 2 == 1) {
                        swap(A, i, j);
                        i++;
                        break;
                    }
                }
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int first = A[i];
        A[i] = A[j];
        A[j] = first;
    }

}
