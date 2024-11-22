package list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = 0, sum = 0;
        int carry = 0;
        ListNode cur = null;
        ListNode result = null;


//        we can use this for loop also
//        for (int sum, val;
//             l1 != null || l2 != null;
//             l1 = l1 == null ? null : l1.next,
//             l2 = l2 == null ? null : l2.next)

        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) +
                    (l2 == null ? 0 : l2.val) + carry;
            val = sum % 10;
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            if (result == null) {
                result = new ListNode(val);
                cur = result;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return result;
    }
}