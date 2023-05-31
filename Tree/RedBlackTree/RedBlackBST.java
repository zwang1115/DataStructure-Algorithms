package Tree.RedBlackTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: O(logn)
 * Space: O(log2n)
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackBST() {
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Empty");
        }
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        while (root != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Empty");
        }
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, RED, 1);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private void check() {
        if (!isBST()) System.out.println("Not in symmetric order");
        if (!isSize()) System.out.println("Subtree counts not consistent");
        if(!is23()) System.out.println("Not 2-3 Tree");
        if(!isBalanced()) System.out.println("Not Black Balanced");
        System.out.println("It is a Red Black Tree");
    }

    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node node, Key min, Key max) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0) return false;
        if (max != null && node.key.compareTo(max) >= 0) return false;
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }

    private boolean isSize() {
        return isSize(root);
    }

    private boolean isSize(Node node) {
        if (node == null) return true;
        if (node.size != size(node.left) + size(node.right) + 1) {
            return false;
        }
        return isSize(node.left) && isSize(node.right);
    }

    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node node) {
        if (node == null) return true;
        if (isRed(node.right)) return false;
        if (node != root && isRed(node) && isRed(node.left)) return false;
        return is23(node.left) && is23(node.right);
    }

    private boolean isBalanced() {
        int black = 0;
        Node node = root;
        while (node != null) {
            if (!isRed(node)) {
                black++;
            }
            node = node.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node node, int black) {
        if (node == null) return black == 0;
        if (!isRed(node)) black--;
        return isBalanced(node.left, black) && isBalanced(node.right, black);
    }
    private void print() {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        System.out.println("root color: " + root.color);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("level: " + (level + 1));
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                System.out.print(cur.key);
                if (cur.left != null) {
                    System.out.println("'s left child: " + cur.left.key + " 's color: " + cur.left.color);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println("'s right child: " + cur.right.key + " 's color: " + cur.right.color);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<>();
        redBlackBST.put(12, 1);
        redBlackBST.put(1, 1);
        redBlackBST.put(9, 1);
        redBlackBST.put(2, 1);
        redBlackBST.put(0, 1);
        redBlackBST.put(11, 1);
        redBlackBST.put(7, 1);
        redBlackBST.put(19, 1);
        redBlackBST.put(4, 1);
        redBlackBST.put(15, 1);
        redBlackBST.put(18, 1);
        redBlackBST.put(5, 1);
        redBlackBST.put(14, 1);
        redBlackBST.put(13, 1);
        redBlackBST.put(10, 1);
        redBlackBST.put(16, 1);
        redBlackBST.put(6, 1);
        redBlackBST.put(3, 1);
        redBlackBST.put(8, 1);
        redBlackBST.put(17, 1);
        redBlackBST.check();
        redBlackBST.print();
    }
}
