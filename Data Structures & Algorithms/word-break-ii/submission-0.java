

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // Step 1: Quick DP check -- can s be segmented at all?
        // canBreak[i] = true if s[i..n-1] can be segmented into dictionary words
        boolean[] canBreak = new boolean[n + 1];
        canBreak[n] = true; // empty suffix is trivially "breakable"

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (canBreak[j] && wordSet.contains(s.substring(i, j))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        // If the whole string can't be segmented, no need to search for sentences
        if (!canBreak[0]) {
            return new ArrayList<>();
        }

        // Step 2: Backtrack + memoize to build actual sentences,
        // pruning any branch where canBreak[i] is false
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, 0, wordSet, canBreak, memo);
    }

    private List<String> backtrack(String s, int start, Set<String> wordSet, 
                                    boolean[] canBreak, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        // Base case: reached the end of the string
        if (start == s.length()) {
            result.add(""); // sentinel: one way to form an "empty" sentence
            memo.put(start, result);
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            // Pruning: skip if the remaining suffix can't be segmented at all
            if (!canBreak[end]) {
                continue;
            }

            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> suffixSentences = backtrack(s, end, wordSet, canBreak, memo);
                for (String suffix : suffixSentences) {
                    // Combine current word with each valid way to complete the rest
                    String sentence = suffix.isEmpty() ? word : word + " " + suffix;
                    result.add(sentence);
                }
            }
        }

        memo.put(start, result);
        return result;
    }
}