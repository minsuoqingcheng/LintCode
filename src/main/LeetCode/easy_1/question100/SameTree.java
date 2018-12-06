package main.LeetCode.easy_1.question100;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
//        boolean res = false;
//        if (p == null && q == null) {
//            return true;
//        } else if (p != null){
//            if (q == null) {
//                return false;
//            } else {
//                res = p.val == q.val;
//                return res && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//            }
//        } else {
//            return false;
//        }
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }



}
