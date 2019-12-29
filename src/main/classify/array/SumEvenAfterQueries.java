package main.classify.array;

public class SumEvenAfterQueries {

    /**
     * 先求总和，再计算每一个元素
     * @param A
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int sum = 0, i = 0;
        for (int a : A) {
            if (a % 2 == 0) sum += a;
        } // sum of even #s.
        int[] ans = new int[queries.length];
        for (int[] q : queries) {
            if (A[q[1]] % 2 == 0) {
                sum -= A[q[1]];
            } // from 1) and 2)
            A[q[1]] += q[0];
            if (A[q[1]] % 2 == 0) {
                sum += A[q[1]];
            } // from 2) and 3)
            ans[i++] = sum;
        }
        return ans;
    }


    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int change = query[0];
            int index = query[1];
            A[index] = A[index] + change;
            res[i] = evenSum(A);
        }
        return res;

    }

    private int evenSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                sum += element;
            }
        }
        return sum;
    }

}
