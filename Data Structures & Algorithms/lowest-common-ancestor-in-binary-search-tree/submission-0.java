public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            // Both nodes are in the right subtree
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            // Both nodes are in the left subtree
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            // Found the split point: curr is the LCA
            else {
                return curr;
            }
        }

        return null;
    }
}