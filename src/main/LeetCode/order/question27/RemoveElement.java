package main.LeetCode.order.question27;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(new int[]{3,2,2,3}, 3);
    }

}
