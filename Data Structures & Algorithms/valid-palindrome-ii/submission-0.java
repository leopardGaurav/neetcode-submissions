class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Ya toh left character hatao, ya right character hatao
                return isPurePalindrome(s, left + 1, right) || isPurePalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Ek simple helper function jo di gayi range me palindrome check karta hai
    private boolean isPurePalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}