public class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Path passing through this node has (leftHeight + rightHeight) edges
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current node to its parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}