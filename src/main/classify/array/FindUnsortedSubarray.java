package main.classify.array;

import java.util.Arrays;
import java.util.Stack;

public class FindUnsortedSubarray {


    public int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length;
        int r = 0;
        //左边的第一个数是不是最小
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        //右边的第一个数是不是最大
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] origin = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != origin[i]) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != origin[i]) {
                end = i;
                break;
            }
        }
        int length = end - start;
        return length == 0 ? 0 : length+1;
    }

}
