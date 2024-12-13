package top_150_interview;

import java.util.Stack;

public class ZZO_CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesV2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        int cnt = 0;
        TreeNode top;
        while (!s.isEmpty()) {
            top = s.pop();
            cnt++;
            if (top.right != null) {
                s.push(top.right);
            }
            if (top.left != null) {
                s.push(top.left);
            }
        }
        return cnt;

    }
}
