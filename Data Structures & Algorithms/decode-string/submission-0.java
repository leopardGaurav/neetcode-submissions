class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currStr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current count and current string context onto stacks
                countStack.push(k);
                stringStack.push(currStr);
                
                // Reset for the nested string inside brackets
                k = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                // Restore context: pop count and preceding string
                int count = countStack.pop();
                StringBuilder prevStr = stringStack.pop();

                // Repeat currStr 'count' times and append to prevStr
                for (int i = 0; i < count; i++) {
                    prevStr.append(currStr);
                }
                currStr = prevStr;
            } else {
                currStr.append(ch);
            }
        }

        return currStr.toString();
    }
}