package top_150_interview;

public class ZZL_CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node after;
        Node copy;
        while (cur != null) {
            after = cur.next;
            copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = after;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            } else {
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null) {
            copy = cur.next;
            cur.next = copy.next;
            if (cur.next != null) {
                copy.next = cur.next.next;
            } else {
                copy.next = null;
            }
            cur = cur.next;
        }
        return res;
    }
}
