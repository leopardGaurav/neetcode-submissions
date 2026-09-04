

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies of each character
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        // Max-Heap to store remaining frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) maxHeap.offer(c);
        }

        // Queue to store pair [remaining_count, available_at_time]
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    queue.offer(new int[]{cnt, time + n});
                }
            }

            // Move tasks out of cooldown queue back into maxHeap
            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }

        return time;
    }
}