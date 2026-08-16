public class Solution {
    private int pre = 0;
    private int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 3001 acts as a sentinel boundary since constraint is -3000 <= node.val <= 3000
        return build(preorder, inorder, 3001);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        
        // Stop building current left subtree when reaching parent root's value in inorder
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, stop);

        return root;
    }
}