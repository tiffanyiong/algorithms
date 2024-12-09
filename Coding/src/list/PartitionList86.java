package list;

public class PartitionList86 {
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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = null, smallTail = null; // < x
        ListNode bigHead = null, bigTail = null;     // > x
        ListNode next = null;

        while (head != null) {
            next = head.next; // 記錄下一個節點 因為之後要斷開會找不回來
            head.next = null; //斷連

            if (head.val < x) {
                if (smallHead == null) {
                    smallHead = head;
                } else {
                    smallTail.next = head;
                }
                smallTail = head;
            } else {
                if (bigHead == null) {
                    bigHead = head;
                } else {
                    bigTail.next = head;
                }
                bigTail = head;
            }
            head = next;
        }
        if (smallHead == null) return bigHead;
        smallTail.next = bigHead;
        return smallHead;
    }
}
