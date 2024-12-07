package top_150_interview;

public class ZZE_Same_tree {

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
}
