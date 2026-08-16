
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Push all left nodes to the stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process the top node (Left/Root)
            curr = stack.pop();
            result.add(curr.val);

            // Move to right subtree
            curr = curr.right;
        }

        return result;
    }
}