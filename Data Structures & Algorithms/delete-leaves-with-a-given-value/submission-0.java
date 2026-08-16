public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        // Process subtrees first (bottom-up)
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // Check if current node became a leaf with value == target
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}