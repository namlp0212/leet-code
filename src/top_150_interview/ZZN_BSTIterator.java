package top_150_interview;

import java.util.Stack;

public class ZZN_BSTIterator {
    class BSTIterator {
        Stack<TreeNode> s;

        public BSTIterator(TreeNode root) {
            s = new Stack<>();
            pushLeft(root);
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode top = s.pop();
            if (top.right != null) {
                pushLeft(top.right);
            }
            return top.val;
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }
    }
}
