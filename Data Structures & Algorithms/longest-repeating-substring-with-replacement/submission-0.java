class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Uppercase English letters (A-Z) ke counts ke liye
        int left = 0;
        int maxCount = 0; // Current window me maximum repeating character ka count
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            count[current - 'A']++;
            
            // Current window me max frequency character ka count track karo
            maxCount = Math.max(maxCount, count[current - 'A']);

            // Window size - maxCount = Baaki bache characters jinhe replace karna padega
            // Agar replacements k se jyada ho gaye, toh left window ko shrink karo
            if ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++; // Window shift kar di
            }

            // Always update the maximum valid window size found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}