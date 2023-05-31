package Tree.LeetCode;

import java.util.HashMap;

public class _106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * Time: O(n)
     * Space: O(h)
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend, HashMap<Integer, Integer> map) {
        if (instart > inend || poststart < 0) {
            return null;
        }
        int rootIndex = map.get(postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = helper(inorder, postorder, instart, rootIndex - 1, poststart, poststart + rootIndex - instart - 1, map);
        root.right = helper(inorder, postorder, rootIndex + 1, inend, poststart + rootIndex - instart, postend - 1, map);
        return root;
    }
}
