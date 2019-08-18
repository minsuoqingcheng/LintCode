package main.other;

/**
 * 给定一个二叉搜索树(BST)，找到树中 第 K 小的节点。
 */
public class KthSmallest {


    public ResultType kthSamllest(TreeNode root, int k) {
        if (root == null) {
            return new ResultType(false, 0);
        }
        ResultType left = kthSamllest(root.left, k);
        if (left.found) {
            return left;
        }
        if (k - left.val == 1) {
            return new ResultType(true, root.val);
        }
        ResultType right = kthSamllest(root.right, k-left.val-1);
        if (right.found) {
            return right;
        }
        //这边+1代表节点自身
        return new ResultType(false, left.val + 1 + right.val);
    }


    public static void main(String[] args) {
        KthSmallest kthSmallest = new main.other.KthSmallest();
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(10);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(1);
        three.left = two;
        three.right = new TreeNode(4);
        root.left = three;
        ResultType resultType = kthSmallest.kthSamllest(root, 1);
        System.out.println(resultType);
    }



    private static class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    private class ResultType {

        private boolean found;  //是否找到
        private int val;    //节点的值

        public ResultType(boolean found, int val) {
            this.found = found;
            this.val = val;
        }

        @Override
        public String toString() {
            return "ResultType{" +
                    "found=" + found +
                    ", val=" + val +
                    '}';
        }
    }
}
