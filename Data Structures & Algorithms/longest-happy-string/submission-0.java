

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max-Heap storing pair of [character_code, count]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));

        if (a > 0) maxHeap.offer(new int[]{'a', a});
        if (b > 0) maxHeap.offer(new int[]{'b', b});
        if (c > 0) maxHeap.offer(new int[]{'c', c});

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            int len = result.length();

            // Check if adding the most frequent character causes 3 in a row
            if (len >= 2 && result.charAt(len - 1) == (char) first[0] && result.charAt(len - 2) == (char) first[0]) {
                // If there is no second character available, we are done
                if (maxHeap.isEmpty()) {
                    break;
                }

                // Pick the second most frequent character
                int[] second = maxHeap.poll();
                result.append((char) second[0]);
                second[1]--;

                // Re-add second character if count remains > 0
                if (second[1] > 0) {
                    maxHeap.offer(second);
                }

                // Push first character back without modifying its count yet
                maxHeap.offer(first);
            } else {
                // Safe to append the most frequent character
                result.append((char) first[0]);
                first[1]--;

                if (first[1] > 0) {
                    maxHeap.offer(first);
                }
            }
        }

        return result.toString();
    }
}