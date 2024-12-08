package top_150_interview;

import java.util.LinkedList;
import java.util.Queue;

public class ZZJ_PopulatingNextRight {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;

        Node current = root; // Node hiện tại của mức hiện tại
        Node head = null;    // Đầu của mức tiếp theo
        Node tail = null;    // Cuối của mức tiếp theo

        while (current != null) {
            while (current != null) {
                // Xử lý con trái
                if (current.left != null) {
                    if (head == null) {
                        head = current.left;
                        tail = current.left;
                    } else {
                        tail.next = current.left;
                        tail = tail.next;
                    }
                }
                // Xử lý con phải
                if (current.right != null) {
                    if (head == null) {
                        head = current.right;
                        tail = current.right;
                    } else {
                        tail.next = current.right;
                        tail = tail.next;
                    }
                }
                // Di chuyển sang node tiếp theo ở mức hiện tại
                current = current.next;
            }
            // Di chuyển xuống mức tiếp theo
            current = head;
            head = null;
            tail = null;
        }

        return root;
    }
}
