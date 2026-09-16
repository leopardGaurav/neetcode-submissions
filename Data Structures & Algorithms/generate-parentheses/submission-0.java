

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(result, current, 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, 
                            int openCount, int closeCount, int n) {
        // Base case: string reached full length
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add an opening parenthesis if we haven't used all n
        if (openCount < n) {
            current.append('(');
            backtrack(result, current, openCount + 1, closeCount, n);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
        // Add a closing parenthesis only if it keeps the string valid
        if (closeCount < openCount) {
            current.append(')');
            backtrack(result, current, openCount, closeCount + 1, n);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}