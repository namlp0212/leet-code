package top_150_interview;

public class ZZB_Add_Two_Number {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prevNode = null;
        ListNode curNode = null;
        ListNode res = null;

        int curVal;
        int mis = 0;
        int val1, val2;
        do {
            val1 = l1 == null ? 0 : l1.val;
            val2 = l2 == null ? 0 : l2.val;
            curVal = (val1 + val2 + mis) >= 10 ? (val1 + val2 + mis) - 10 : (val1 + val2 + mis);
            curNode = new ListNode(curVal);
            mis = (val1 + val2 + mis) / 10;
            if (prevNode != null) {
                prevNode.next = curNode;
            } else {
                res = curNode;
            }
            prevNode = curNode;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        } while (l1 != null || l2 != null);

        if (mis != 0) {
            curNode = new ListNode(mis);
            if (prevNode != null) {
                prevNode.next = curNode;
            } else {
                res = curNode;
            }
        }

        return res;
    }
}
