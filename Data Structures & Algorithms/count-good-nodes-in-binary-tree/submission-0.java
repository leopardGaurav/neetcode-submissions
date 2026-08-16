public class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;

        int count = 0;
        // A node is good if its value is >= max value on path from root
        if (node.val >= maxVal) {
            count = 1;
            maxVal = node.val; // Update max value for children
        }

        count += dfs(node.left, maxVal);
        count += dfs(node.right, maxVal);

        return count;
    }
}