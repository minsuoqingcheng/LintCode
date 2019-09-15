package main.play_algorithm_interview.chap3;

public class Sort_Colors {

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }


    public void sortColors2(int[] nums) {
        int zero = -1;              //nums[0, zero] = 0;
        int two = nums.length;      //num[two, n-1] = 2;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else if (nums[i] == 0){
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
