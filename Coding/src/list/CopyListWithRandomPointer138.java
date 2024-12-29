package list;

// https://leetcode.cn/problems/copy-list-with-random-pointer/description/
public class CopyListWithRandomPointer138 {

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

        // 把新节点直接插到原节点的后面
        Node cur = head;
        Node next = null;
        // 1 -> 2 -> 3   to     1 -> 1' -> 2 -> 2' -> 3 -> 3'
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        cur = head; // 重新遍歷, 現在要把random的copy
        Node copy = null;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            // 1 -> 1' -> 2 -> 2' -> 3 -> 3'
            // 假設 1 的 random node指向 3，那 1的random 指向 3的下個節點 3'，就是要copy的node
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }

        // 把鏈錶分離
        Node newHead = head.next; // 1    ->  1'         -> 2   -> 2'
        // head    (head.next)
        cur = head;
        while (cur != null) {
            next = cur.next.next; // 2
            copy = cur.next;
            cur.next = next; // head （1） 跟 2 連上
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return newHead;
    }
}
