package main.classify.binarysearch;

import main.classify.basic.TreeNode;

public class IsValidBST {

    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        } else {
            pre = root;
        }
        return isValidBST(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        TreeNode left = new TreeNode(1);
//        root.left = left;
        IsValidBST demo = new IsValidBST();
        System.out.println(demo.isValidBST(root));
    }
}
