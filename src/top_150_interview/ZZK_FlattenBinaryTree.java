package top_150_interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZZK_FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();

        q.add(root);
        TreeNode prev = null;
        TreeNode cur;

        while (!q.isEmpty() || !s.isEmpty()) {
            if (!q.isEmpty()) {
                cur = q.poll();

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    s.push(cur.right);
                }

                if (prev != null) {
                    prev.left = null;
                    prev.right = cur;
                }

                prev = cur;
            } else {
                cur = s.pop();

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    s.push(cur.right);
                }

                if (prev != null) {
                    prev.left = null;
                    prev.right = cur;
                }

                prev = cur;
            }
        }
    }
}
