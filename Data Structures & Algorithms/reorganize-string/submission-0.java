
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max-Heap storing [character_code, frequency]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // Impossible to arrange without adjacent duplicates
                if (freq[i] > (s.length() + 1) / 2) {
                    return "";
                }
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = null;

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            result.append((char) (current[0] + 'a'));
            current[1]--; // Decrement frequency

            // Re-add previous character back to heap if it still has remaining frequency
            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }

            // Hold current character so it isn't picked immediately in the next step
            prev = current;
        }

        return result.length() == s.length() ? result.toString() : "";
    }
}