public class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word.toCharArray(), 0, root);
    }

    private boolean searchHelper(char[] chars, int index, TrieNode curr) {
        for (int i = index; i < chars.length; i++) {
            char ch = chars[i];
            
            if (ch == '.') {
                // Wildcard: try all 26 possible branches recursively
                for (TrieNode child : curr.children) {
                    if (child != null && searchHelper(chars, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = ch - 'a';
                if (curr.children[idx] == null) {
                    return false;
                }
                curr = curr.children[idx];
            }
        }
        return curr.isEnd;
    }
}