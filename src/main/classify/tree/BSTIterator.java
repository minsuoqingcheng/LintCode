package main.classify.tree;

import main.classify.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {

    private int index = 0;
    private List<Integer> vales;

    public BSTIterator(TreeNode root) {
        vales = new ArrayList<>();
        inOrder(root);
    }
    
    public int next() {
        return vales.get(index++);
    }
    
    public boolean hasNext() {
        return vales.size() > index;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                inOrder(root.left);
            }
            vales.add(root.val);
            if (root.right != null) {
                inOrder(root.right);
            }
        }
    }
}