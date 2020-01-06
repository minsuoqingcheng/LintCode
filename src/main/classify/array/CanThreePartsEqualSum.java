package main.classify.array;

public class CanThreePartsEqualSum {

    /**
     * 根据结果反推
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        int partialSum = 0;
        for (int a : A) {
            partialSum += a;
            if (partialSum == sum / 3) {
                partialSum = 0;
            }
        }
        return partialSum == 0;
    }

}
