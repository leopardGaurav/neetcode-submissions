

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        // If visiting this depth for the first time, it's the rightmost node
        if (level == result.size()) {
            result.add(node.val);
        }

        // Traverse right subtree first, then left
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}