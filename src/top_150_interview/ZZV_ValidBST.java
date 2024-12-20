package top_150_interview;

import java.util.ArrayList;
import java.util.List;

public class ZZV_ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = visitTree(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> visitTree(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        List<Integer> left = visitTree(root.left);
        List<Integer> right = visitTree(root.right);
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
