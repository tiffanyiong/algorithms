package list;

// https://leetcode.cn/problems/reverse-linked-list-ii/
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode prev = null;
        ListNode cur = head;

        for (int i = 1; i < left; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode tail = cur;
        ListNode connection = prev; // reverse前 左range的前一位


        ListNode next = null;
        for (int i = 0; i < right - left + 1; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev; // 即它range前面沒有reverse 不需要連接
        }
        // 1 -> 2 -> 3 -> 4 -> 5 left = 2 right = 4
        // 1 -> 4 -> 3 -> 2 -> 5 tail = 2 cur = 5
        tail.next = cur;

        return head;
    }
}
