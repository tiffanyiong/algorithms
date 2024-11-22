package list;

public class LinkedList {

    public ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
