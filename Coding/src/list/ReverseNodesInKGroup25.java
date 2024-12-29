package list;

// https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head; // empty list or k = 1

        // count the number of nodes in the list
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode prevGroupTail = null; // Tail of the previous group
        ListNode cur = head;       // current node being processed
        ListNode newHead = null;    // New head of the list after the first reversal

        // reverse per K nodes at a time
        for (; n >= k; n -= k) {
            ListNode groupHead = cur; // save the head of the current group
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            // if this is the first group, update the new head
            if (newHead == null) {
                newHead = prev;
            }



            // connect the previous group's tail to the current group's new head
            if (prevGroupTail != null) {
                prevGroupTail.next = prev;
            }

            // update the tail of the current group
            prevGroupTail = groupHead;

        }

        // connect the remainningnodes (if any) to the last group's tail
        if (prevGroupTail != null) {
            prevGroupTail.next = cur;
        }

        return newHead;
    }
}
