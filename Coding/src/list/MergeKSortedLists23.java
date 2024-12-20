package list;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/merge-k-sorted-lists/description/
public class MergeKSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode head: lists) {
            // traverse all the heads
            if (head != null) {
                minHeap.add(head);
            }
        }
        if (minHeap.isEmpty()) return null;


        // 先彈出一個node做總結點, 最後返回總結點喔
        ListNode head = minHeap.poll();
        ListNode prev = head;
        // 彈出之後，要把它的下個節點重新放到堆裡
        if (prev.next != null) minHeap.add(prev.next);
        while (!minHeap.isEmpty()) {
            // 彈出一個
            ListNode cur = minHeap.poll();
            // 把它連到鏈表裡
            prev.next = cur;
            // prev 就指到cur的位置上
            prev = prev.next; // prev = cur
            // 如果prev的下個node不為空就放到小根堆裡
            if (prev.next != null) {
                minHeap.add(prev.next);
            }
        }
        return head;

    }
}