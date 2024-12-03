package top_150_interview;

public class ZZG_Symmetric_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (q == null) {
                return false;
            } else {
                if (p.val == q.val) {
                    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
                } else {
                    return false;
                }
            }
        }
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode revertRight = invertTree(right);
        return isSameTree(left, revertRight);
    }
}
