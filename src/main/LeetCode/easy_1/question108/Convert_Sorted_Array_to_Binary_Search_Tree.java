package main.LeetCode.easy_1.question108;

import main.LeetCode.TreeNode;

public class Convert_Sorted_Array_to_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return helper(nums, 0, nums.length -1);
    }


    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int middle = (low + high) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = helper(nums, low, middle-1);
        node.right = helper(nums, middle+1, high);
        return node;
    }



}
