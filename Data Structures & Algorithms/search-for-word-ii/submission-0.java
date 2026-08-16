public class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int idx = board[r][c] - 'a';
                if (root.children[idx] != null) {
                    dfs(board, r, c, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char ch = board[r][c];
        int idx = ch - 'a';
        TrieNode curr = parent.children[idx];

        // Base case: no prefix match in Trie
        if (curr == null) return;

        // Word match found
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null; // Prevent duplicate additions
        }

        // Mark cell as visited in-place
        board[r][c] = '#';

        // Explore 4-directional neighbors
        if (r > 0 && board[r - 1][c] != '#') dfs(board, r - 1, c, curr, result);
        if (r < board.length - 1 && board[r + 1][c] != '#') dfs(board, r + 1, c, curr, result);
        if (c > 0 && board[r][c - 1] != '#') dfs(board, r, c - 1, curr, result);
        if (c < board[0].length - 1 && board[r][c + 1] != '#') dfs(board, r, c + 1, curr, result);

        // Backtrack board state
        board[r][c] = ch;

        // Dynamic Trie Pruning: Remove dead-end leaf nodes
        boolean hasChildren = false;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                hasChildren = true;
                break;
            }
        }
        if (!hasChildren) {
            parent.children[idx] = null;
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = w; // Direct reference saves string construction overhead
        }
        return root;
    }
}