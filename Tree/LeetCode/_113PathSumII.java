package Tree.LeetCode;
import java.util.ArrayList;
import java.util.List;
public class _113PathSumII {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<>(), root, targetSum);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int targetSum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(res, list, root.left, targetSum - root.val);
        helper(res, list, root.right, targetSum - root.val);
        list.remove(list.size() - 1);
    }
}
