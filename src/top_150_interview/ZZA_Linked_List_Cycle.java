package top_150_interview;

public class ZZA_Linked_List_Cycle {

     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }

    public boolean hasCycle(ListNode head) {
         if (head == null || head.next == null) {
             return false;
         }
         ListNode fast = head.next;
         ListNode slow = head;
         while (slow != fast) {
             if (fast == null || slow == null) {
                 return false;
             }
             fast = head.next.next;
             slow = head.next;
         }
         return true;
    }
}
