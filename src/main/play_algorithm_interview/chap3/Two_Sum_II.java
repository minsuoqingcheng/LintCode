package main.play_algorithm_interview.chap3;

public class Two_Sum_II {

    public int[] twoSum(int[] numbers, int target) {
        int start = 1;
        int end = numbers.length;
        while (start < end) {
            int temp = numbers[start-1] + numbers[end-1];
            if (temp == target) {
                return new int[]{start, end};
            } else if (temp > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }

}
