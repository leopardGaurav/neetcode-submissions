public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Map each character to its position (rank) in the alien alphabet
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }

        // Compare each adjacent pair of words
        for (int i = 0; i < words.length - 1; i++) {
            if (!inCorrectOrder(words[i], words[i + 1], charOrder)) {
                return false;
            }
        }

        return true;
    }

    private boolean inCorrectOrder(String word1, String word2, int[] charOrder) {
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (c1 != c2) {
                // First differing character determines the order
                return charOrder[c1 - 'a'] < charOrder[c2 - 'a'];
            }
        }

        // All compared characters matched -- shorter word must come first
        // (e.g., "app" before "apple" is valid, but "apple" before "app" is not)
        return word1.length() <= word2.length();
    }
}