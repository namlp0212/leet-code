package top_150_interview;

import java.util.*;

public class ZZU_MinimumAbsoluteDiff {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = visitTree(root);
        int res = Integer.MAX_VALUE;
        int len = list.size();

        for (int i = 1; i < len; i++) {
            res = Math.min(res, list.get(i) - list.get(i-1));
        }
        return res;
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
