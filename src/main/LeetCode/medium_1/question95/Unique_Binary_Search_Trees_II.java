package main.LeetCode.medium_1.question95;

import main.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return genTrees(1, n);
    }


    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i-1);
            right = genTrees(i+1, end);
            for (TreeNode lNode: left) {
                for (TreeNode rNode: right) {
                    TreeNode node = new TreeNode(i);
                    node.left = lNode;
                    node.right = rNode;
                    list.add(node);
                }
            }
        }
        return list;
    }

}
