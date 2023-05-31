package Graph.LeetCode;

import java.util.HashMap;

public class _138CopyListWithRandomPointer {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }








    //Definition of Node
    class Node {
        int val;
        Node next, random;
        Node(int x) {
            this.val = x;
        }
    }
}
