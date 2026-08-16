public class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2]; // {notRobbed, robbed}
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] res = new int[2];
        
        // Option 1: Do NOT rob current node -> can choose to rob or skip children
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // Option 2: Rob current node -> CANNOT rob direct children
        res[1] = node.val + left[0] + right[0];

        return res;
    }
}