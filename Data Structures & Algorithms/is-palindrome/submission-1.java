class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Agar left character alphanumeric nahi hai, toh aage badho
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Agar right character alphanumeric nahi hai, toh piche badho
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Dono ko lower case me badal kar compare karo
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}