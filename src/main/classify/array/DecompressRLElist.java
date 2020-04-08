package main.classify.array;

public class DecompressRLElist {

    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i+=2) {
            length += nums[i];
        }
        int[] res = new int[length];
        int index = 0;
        for (int i = 0; i < nums.length; i+=2) {
            int count = nums[i];
            int num = nums[i+1];
            while (count > 0) {
                res[index] = num;
                index++;
                count--;
            }
        }
        return res;
    }

}
