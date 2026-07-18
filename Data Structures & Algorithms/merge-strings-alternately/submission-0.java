public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        // Optimize memory allocation by sizing the builder to the exact final length
        StringBuilder merged = new StringBuilder(len1 + len2);
        
        // Run a single loop up to the length of the longer string
        int maxLength = Math.max(len1, len2);
        for (int i = 0; i < maxLength; i++) {
            if (i < len1) {
                merged.append(word1.charAt(i));
            }
            if (i < len2) {
                merged.append(word2.charAt(i));
            }
        }
        
        return merged.toString();
    }
}