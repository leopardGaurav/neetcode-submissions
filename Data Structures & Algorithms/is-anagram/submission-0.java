class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        // 26 alphabets ke liye count array
        int[] count = new int[26];
        
        // Ek hi loop me dono strings par traverse karenge
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // s ke character ke liye +1
            count[t.charAt(i) - 'a']--; // t ke character ke liye -1
            
            // Note: 's.charAt(i) - 'a'' karne se hume 0 se 25 ke
            // beech ki index milti hai.
        }
        
        // Agar saare counts 0 hain, toh anagram hai
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}