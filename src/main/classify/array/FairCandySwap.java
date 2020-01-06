package main.classify.array;

import java.rmi.UnexpectedException;
import java.util.HashSet;
import java.util.Set;

/**
 * 将数组A中的一个元素和数组B中一个元素交换，是的数组A的和等于数组B的和
 */
public class FairCandySwap {

    /**
     * sum(A) = Sa ; sum(B) = Sb
     * 由此可得 Sa - x + y = Sb + x - y
     * y = x + 1/2(Sb-Sa)
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int ele : A) {
            sumA += ele;
        }
        Set<Integer> sb = new HashSet<>();
        for (int ele : B) {
            sumB += ele;
            sb.add(ele);
        }
        int delta = (sumB - sumA) / 2;

        for (int ele : A) {
            if (sb.contains(ele + delta)) {
                return new int[]{ele, ele+delta};
            }
        }

        throw null;
    }

}
