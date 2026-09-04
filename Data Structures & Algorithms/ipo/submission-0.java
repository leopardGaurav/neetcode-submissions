
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        // Step 1: Combine project capital and profit into a 2D array
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        // Sort projects by capital required in ascending order
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        // Max-Heap to store available profits of affordable projects
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        int ptr = 0; // Pointer to iterate through sorted projects
        // Step 2: Pick up to k projects greedily
        for (int i = 0; i < k; i++) {
            // Push all projects that can be afforded with current capital into max-heap
            while (ptr < n && projects[ptr][0] <= w) {
                maxProfitHeap.offer(projects[ptr][1]);
                ptr++;
            }
            // If no projects can be afforded, stop early
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            // Pick the affordable project with the maximum profit
            w += maxProfitHeap.poll();
        }
        return w;
    }
}