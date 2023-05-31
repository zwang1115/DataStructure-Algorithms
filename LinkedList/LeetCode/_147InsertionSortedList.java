package LinkedList.LeetCode;

public class _147InsertionSortedList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        ListNode pre = null;
        dummy.next = head;

        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                pre = dummy;
                while (pre.next.val <= temp.val) {
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }
}
