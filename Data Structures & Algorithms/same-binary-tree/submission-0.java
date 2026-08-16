public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null -> structural match at leaf end
        if (p == null && q == null) return true;
        
        // One is null or values mismatch -> not structural/value equivalent
        if (p == null || q == null || p.val != q.val) return false;
        
        // Check left and right subtrees recursively
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}