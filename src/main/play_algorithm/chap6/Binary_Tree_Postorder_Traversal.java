package main.play_algorithm.chap6;

import main.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {

    private static final String GET = "get";
    private static final String VISIT = "visit";

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(VISIT, root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            TreeNode node = command.node;
            if (GET.equals(command.operation)) {
                result.add(node.val);
            } else {
                stack.push(new Command(GET, node));
                if (node.right != null) {
                    stack.push(new Command(VISIT, node.right));
                }
                if (node.left != null) {
                    stack.push(new Command(VISIT, node.left));
                }
            }
        }
        return result;
    }


    // recursively
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> ret) {
        if (root != null) {
            dfs(root.left, ret);
            dfs(root.right, ret);
            ret.add(root.val);
        }
    }


    private static class Command {
        private String operation;
        private TreeNode node;

        Command(String operation, TreeNode node) {
            this.operation = operation;
            this.node = node;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }
    }

}
