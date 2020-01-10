package main.classify.array;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = length * (length + 1) / 2;
        for (int i = 0; i < length; i++) {
            sum -= nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        MissingNumber test = new MissingNumber();
        System.out.println(test.missingNumber(new int[]{3, 0, 1}));
    }
}
