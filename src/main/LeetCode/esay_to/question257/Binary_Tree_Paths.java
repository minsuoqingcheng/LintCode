package main.LeetCode.esay_to.question257;

import main.LeetCode.TreeNode;

import java.util.*;

public class Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, result, "");
        return result;
    }

    private void helper(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }
        path = path + root.val + "->";
        helper(root.left, result, path);
        helper(root.right, result, path);
    }


    //BFS（广度优先遍历 breadth-first search）
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Queue<TreeNode> qNode = new LinkedList<TreeNode>();
        Queue<String> qStr = new LinkedList<String>();
        if (root == null) {
            return list;
        }
        qNode.add(root);
        qStr.add("");
        while (!qNode.isEmpty()) {
            TreeNode curNode = qNode.remove();
            String curStr = qStr.remove();
            if (curNode.left == null && curNode.right == null) {
                list.add(curStr + curNode.val);
            }
            if (curNode.left != null) {
                qNode.add(curNode.left);
                qStr.add(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                qNode.add(curNode.right);
                qStr.add(curStr + curNode.val + "->");
            }
        }
        return list;
    }


    //DFS（深度优先遍历 depth-first search）
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<String> sStr = new Stack<String>();
        if (root == null) {
            return list;
        }
        sNode.push(root);
        sStr.push("");
        while (!sNode.isEmpty()) {
            TreeNode curNode = sNode.pop();
            String curStr = sStr.pop();
            if (curNode.left == null && curNode.right == null) {
                list.add(curStr + curNode.val);
            }
            if (curNode.left != null) {
                sNode.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                sNode.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }
        return list;
    }

}
