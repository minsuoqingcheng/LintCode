package main.LeetCode.easy_to.question167;

import java.util.Arrays;

public class Two_Sum_II {

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    return new int[]{i+1, j+1};
                } else if (sum > target) {
                    break;
                }
            }
        }
        return new int[]{-1, -1};
    }


    public int[] twoSum2(int[] numbers, int target) {
        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) return indice;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }


    public static void main(String[] args) {
        Two_Sum_II test = new Two_Sum_II();
        System.out.println(Arrays.toString(test.twoSum(new int[]{-1, 0}, -1)));
    }
}
