package Tree.AVL.impl;

import Tree.AVL.AVLNode;
import Tree.AVL.IAVLTree;
import Tree.BinarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeImpl implements IAVLTree {

    AVLNode root;

    int size;

    public AVLTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    public AVLNode add(AVLNode node, int val) {
        if (node == null) {
            size++;
            return new AVLNode(val);
        }

        if (node.val == val) {
            throw new IllegalArgumentException("Node Already Existed");
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }

        node.height = 1 + Math.max(getHeight(node.left) ,getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balanceFactor < -1  && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private AVLNode remove(AVLNode node , int val) {
        if (node == null) {
            return null;
        }

        AVLNode changeNode;
        if (node.val > val) {
            node.left = remove(node.left, val);
            changeNode = node;
        } else if (node.val < val) {
            node.right = remove(node.right, val);
            changeNode = node;
        } else {
            if (node.left == null) {
                size--;
                changeNode = node.right;
            } else if (node.right == null) {
                size--;
                changeNode = node.left;
            } else {
                AVLNode minNode = findMin(node.right);
                node.val = minNode.val;
                node.right = remove(node.right, node.val);
                changeNode = node;
            }

        }

        if (changeNode == null) {
            return null;
        }

        changeNode.height = 1 + Math.max(getHeight(changeNode.left) ,getHeight(changeNode.right));
        int balanceFactor = getBalanceFactor(changeNode);

        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) >= 0) {
            return rightRotate(changeNode);
        }
        if (balanceFactor < -1  && getBalanceFactor(changeNode.right) <= 0) {
            return leftRotate(changeNode);
        }
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) < 0) {
            changeNode.left = leftRotate(changeNode.left);
            return rightRotate(changeNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) > 0) {
            changeNode.right = rightRotate(changeNode.right);
            return leftRotate(changeNode);
        }
        return changeNode;
    }

    private AVLNode findMin(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(AVLNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        } else if (node.val > val) {
            return contains(node.left, val);
        } else {
            return contains(node.right, val);
        }
    }

    private AVLNode rightRotate(AVLNode x) {
        AVLNode y = x.left;
        AVLNode c = y.right;

        y.right = x;
        x.left = c;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode c = y.left;

        y.left = x;
        x.right = c;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    private int getBalanceFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private boolean isBST(AVLNode node) {
        if (node == null) return true;
        return isBST(node, null, null);
    }

    private boolean isBST(AVLNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    //Check If Balanced (Approach two)
    private boolean isBalanced(AVLNode node) {
        if (node == null) return true;
        return helper(node) != -1;
    }

    private int helper(AVLNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    //Check If Balanced (Approach two)
    private boolean isBalanced2(AVLNode node) {
        if (node == null) return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced2(node.left) && isBalanced2(node.right);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }



    private void print() {
        int level = 0;
        Queue<AVLNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("level: " + (level + 1));
            for (int i = 0; i < size; i++) {
                AVLNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    System.out.println("'s left child: " + cur.left.val);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    System.out.println("'s right child: " + cur.right.val);
                    queue.offer(cur.right);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        AVLTreeImpl avlTree = new AVLTreeImpl();
        avlTree.add(8);
        avlTree.add(5);
        avlTree.add(6);
        avlTree.add(3);
        avlTree.add(10);
        avlTree.add(9);
        avlTree.add(11);
        avlTree.add(2);
        avlTree.remove(11);
        avlTree.print();
        System.out.println("Is it A BST: " + avlTree.isBST(avlTree.root));
        System.out.println("Is it A Balanced BST: " + avlTree.isBalanced(avlTree.root));
        System.out.println("size: " + avlTree.size());
    }
}
