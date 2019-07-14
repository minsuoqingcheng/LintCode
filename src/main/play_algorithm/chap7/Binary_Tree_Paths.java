package main.play_algorithm.chap7;

import main.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.val+"");
        }

        List<String> leftPath = binaryTreePaths(root.left);
        for (int i = 0; i < leftPath.size(); i++) {
            ans.add(root.val + "->" + leftPath.get(i));
        }
        List<String> rightPath = binaryTreePaths(root.right);
        for (int i = 0; i < rightPath.size(); i++) {
            ans.add(root.val + "->" + rightPath.get(i));
        }

        return ans;
    }

}
