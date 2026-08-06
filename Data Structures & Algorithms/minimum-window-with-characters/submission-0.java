
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] countT = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            countT[c]++;
        }

        // Count unique characters required from t
        int need = 0;
        for (int count : countT) {
            if (count > 0) need++;
        }

        int have = 0;
        int resLen = Integer.MAX_VALUE;
        int resStart = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window[c]++;

            // If current char frequency matches t's required frequency
            if (countT[c] > 0 && window[c] == countT[c]) {
                have++;
            }

            // Shrink window from the left while it contains all chars of t
            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    resStart = l;
                }

                char leftChar = s.charAt(l);
                window[leftChar]--;
                
                if (countT[leftChar] > 0 && window[leftChar] < countT[leftChar]) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + resLen);
    }
}