class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Pehli string ko hi min aur max maan lete hain
        String minStr = strs[0];
        String maxStr = strs[0];
        
        // Single loop chala kar alphabetically sabse choti aur badi string dhoodhein
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].compareTo(minStr) < 0) {
                minStr = strs[i]; // Sabse choti (First)
            }
            if (strs[i].compareTo(maxStr) > 0) {
                maxStr = strs[i]; // Sabse badi (Last)
            }
        }
        
        // Ab sirf in dono (Min aur Max) ko compare karein
        int idx = 0;
        while (idx < minStr.length() && idx < maxStr.length()) {
            if (minStr.charAt(idx) == maxStr.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        
        return minStr.substring(0, idx);
    }
}