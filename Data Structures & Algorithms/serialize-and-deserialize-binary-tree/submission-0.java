public class Codec {
    // Encodes a tree to a single string using Pre-Order DFS
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }
    private void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }
    // Decodes encoded data back to tree without extra array allocations
    public TreeNode deserialize(String data) {
        int[] index = new int[]{0};
        return deserializeDFS(data, index);
    }

    private TreeNode deserializeDFS(String data, int[] index) {
        if (index[0] >= data.length()) return null;

        // Base case: null node marker '#'
        if (data.charAt(index[0]) == '#') {
            index[0] += 2; // Skip '#,'
            return null;
        }

        // Fast zero-allocation integer parsing
        int val = 0;
        boolean isNegative = false;

        if (data.charAt(index[0]) == '-') {
            isNegative = true;
            index[0]++;
        }

        while (data.charAt(index[0]) != ',') {
            val = val * 10 + (data.charAt(index[0]) - '0');
            index[0]++;
        }
        if (isNegative) val = -val;
        index[0]++; // Skip ','

        TreeNode node = new TreeNode(val);
        node.left = deserializeDFS(data, index);
        node.right = deserializeDFS(data, index);

        return node;
    }
}