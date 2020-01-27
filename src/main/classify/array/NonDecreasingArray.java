package main.classify.array;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int errorIndex = errorPos(nums);
        if (errorIndex == -1) {
            return true;
        }

        int nextNum = nums[errorIndex+1];
        nums[errorIndex+1] = nums[errorIndex];
        if (errorPos(nums) == -1) {
            return true;
        }

        nums[errorIndex] = nextNum;
        nums[errorIndex+1] = nextNum;
        if (errorPos(nums) == -1) {
            return true;
        }
        return false;
    }


    private int errorPos(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        NonDecreasingArray test = new NonDecreasingArray();
        System.out.println(test.checkPossibility(new int[]{2,3,3,2,4}));
    }
}
