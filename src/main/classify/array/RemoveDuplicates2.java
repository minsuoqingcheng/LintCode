package main.classify.array;

public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int sameSize = 1;
        int sameIndex = 0;
        int total = nums.length;
        for (int i = 1; i < total; i++) {
            if (nums[i] == nums[i-1]) {
                sameSize++;
                if (i == total - 1 && sameSize > 2) {
                    total = total - (sameSize - 2);
                }
            } else {
                if (sameSize > 2) {
                    for (int j = i; j < total; j++) {
                        nums[sameIndex+(j-i)] = nums[j];
                    }
                    total = total - (sameSize - 2);
                    i = i - (sameSize - 2);
                }
                sameSize = 1;
            }
            if (sameSize <= 2) {
                sameIndex = i+1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        RemoveDuplicates2 test = new RemoveDuplicates2();
        System.out.println(test.removeDuplicates(new int[]{1,1,1,2,2,2,3,3}));
    }
}
