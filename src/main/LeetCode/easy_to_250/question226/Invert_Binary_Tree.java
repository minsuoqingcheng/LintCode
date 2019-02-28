package main.LeetCode.easy_to_250.question226;

import main.LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_Binary_Tree {


    public TreeNode invertTree(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.right);
            invertTree(root.left);
        }
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

}
