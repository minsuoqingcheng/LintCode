package main.classify.everyday;

public class MaxArea {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                max = Math.max(max, height[i] * (j-i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j-i));
                j--;
            }
        }
        return max;
    }

}
