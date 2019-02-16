package main.LeetCode.easy_to.question169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Majority_Element {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        int half = length / 2;
        Map<Integer, Integer> statistic = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int element = nums[i];
            Integer count = statistic.get(element);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            if (count > half) {
                return element;
            }
            statistic.put(element, count);
        }
        return -1;
    }


    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {

        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;

        }
        return major;
    }


}
