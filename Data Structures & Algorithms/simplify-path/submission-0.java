class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            // Ignore empty strings (from consecutive slashes) and current directory '.'
            if (token.equals("") || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                // Go up one directory by popping from stack
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push valid directory or file names (e.g., "a", "...", "filename")
                stack.push(token);
            }
        }

        // Reconstruct path from root to target (bottom of stack to top)
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/").append(stack.pollLast());
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}