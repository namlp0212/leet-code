package top_150_interview;

public class ZZP_LowestAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root; // p và q ở hai nhánh
        return (left != null) ? left : right; // Cả hai nằm ở một nhánh
    }
}
