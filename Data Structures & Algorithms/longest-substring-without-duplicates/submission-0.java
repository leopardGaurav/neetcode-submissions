class Solution {
    public int lengthOfLongestSubstring(String s) {
        // ASCII characters (128 total) ke last seen index store karne ke liye array
        int[] lastIndex = new int[128];
        
        // Array ko -1 se initialize karenge taaki pta chale character abhi tak nahi dekha gaya
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }
        
        int left = 0;
        int maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Agar character pehle mil chuka hai AUR current window ke andar hai
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1; // Window shifting
            }
            
            lastIndex[currentChar] = right; // Current index Update karo
            maxLen = Math.max(maxLen, right - left + 1); // Max length track karo
        }
        
        return maxLen;
    }
}