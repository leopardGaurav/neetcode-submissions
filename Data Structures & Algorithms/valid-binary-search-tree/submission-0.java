public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        // Current node value must strictly fit within (min, max)
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left child upper bound becomes node.val; Right child lower bound becomes node.val
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}