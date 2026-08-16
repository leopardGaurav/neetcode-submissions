public class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public int minExtraChar(String s, String[] dictionary) {
        // 1. Build Trie from dictionary
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
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

        char[] chars = s.toCharArray();
        int n = chars.length;
        // dp[i] represents min extra characters needed for suffix s[i...n-1]
        int[] dp = new int[n + 1];

        // 2. Bottom-up DP from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Option 1: Treat character at index i as an extra character
            dp[i] = 1 + dp[i + 1];

            // Option 2: Check for valid dictionary words starting at index i using Trie
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                int idx = chars[j] - 'a';
                if (curr.children[idx] == null) {
                    break; // Early exit: no dictionary word matches this prefix
                }
                curr = curr.children[idx];
                if (curr.isEnd) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}