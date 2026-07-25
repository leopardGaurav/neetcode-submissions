
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        // Edge case: s1 cannot fit inside s2
        if (len1 > len2) {
            return false;
        }
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Step 1: Fill frequencies for the first window
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Step 2: Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Check if current window frequencies match
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            
            // Add new character coming into the window
            s2Count[s2.charAt(i) - 'a']++;
            
            // Remove old character leaving the window
            s2Count[s2.charAt(i - len1) - 'a']--;
        }
        
        // Check the last window after the loop finishes
        return Arrays.equals(s1Count, s2Count);
    }
}