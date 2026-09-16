

public class Solution {
    private static final String[] DIGIT_TO_LETTERS = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        StringBuilder current = new StringBuilder();
        backtrack(digits, 0, current, result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, 
                            List<String> result) {
        // Base case: built a combination for every digit
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        int digit = digits.charAt(index) - '0';
        String letters = DIGIT_TO_LETTERS[digit];

        // Try each letter for this digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}