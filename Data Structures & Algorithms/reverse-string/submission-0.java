class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        
        while (l < r) {
            // Swapping s[l] and s[r] using a temp variable
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            
            // Pointers ko move kar rahe hain
            l++;
            r--;
        }
    }
}