package main.classify.everyday;

import main.classify.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);
        }
        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }

}
