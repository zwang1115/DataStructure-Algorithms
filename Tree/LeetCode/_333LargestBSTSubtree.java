package Tree.LeetCode;

public class _333LargestBSTSubtree {

    /**
     * Time :O(n)
     * Space: O(n)
     */
    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root);
        return res;
    }

    private SearchNode helper(TreeNode root) {
        if (root == null) return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        SearchNode left = helper(root.left);
        SearchNode right = helper(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new SearchNode(-1, 0 , 0);
        }
        int size = left.size + right.size + 1;
        res = Math.max(res, size);
        return new SearchNode(size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
    }

    class SearchNode {
        int size;
        int lower;
        int upper;

        SearchNode(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
