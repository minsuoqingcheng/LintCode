package main.play_algorithm_interview.chap6;

import main.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair head = queue.poll();
            TreeNode node = head.node;
            Integer layer = head.layer;

            if (ans.size() == layer) {
                List<Integer> values = new ArrayList<>();
                values.add(node.val);
                ans.add(values);
            } else {
                List<Integer> values = ans.get(layer);
                values.add(node.val);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, layer+1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, layer+1));
            }
        }

        return ans;
    }

    static class Pair {

        private TreeNode node;
        private Integer layer;

        Pair(TreeNode node, Integer layer) {
            this.node = node;
            this.layer = layer;
        }

    }
}
