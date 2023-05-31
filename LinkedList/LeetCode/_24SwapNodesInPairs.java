package LinkedList.LeetCode;


public class _24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode newStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = newStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

}
