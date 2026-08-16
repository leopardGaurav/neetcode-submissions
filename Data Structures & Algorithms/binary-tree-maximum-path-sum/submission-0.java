public class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Ignore negative path sums by clamping to 0
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));

        // Path sum with the current node as the peak/split point
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);

        // Return max gain obtainable by extending one branch to the parent
        return node.val + Math.max(leftMax, rightMax);
    }
}