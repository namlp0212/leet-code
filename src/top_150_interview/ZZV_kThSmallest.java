package top_150_interview;

import java.util.ArrayList;
import java.util.List;

public class ZZV_kThSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = visitTree(root);
        return list.get(k-1);
    }

    public List<Integer> visitTree(TreeNode root, int k) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        List<Integer> left = visitTree(root.left, k);
        List<Integer> right = visitTree(root.right, k);
        if (left != null) {
            list.addAll(left);
        }
        list.add(root.val);
        if (right != null) {
            list.addAll(right);
        }
        return list;
    }
}
