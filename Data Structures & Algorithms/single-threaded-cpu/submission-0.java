
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        // Step 1: Create an array storing [enqueueTime, processingTime, originalIndex]
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        // Sort tasks primarily by enqueueTime ascending
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-Heap: Sort by processingTime, then by originalIndex
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]); // Shortest processing time first
            }
            return Integer.compare(a[2], b[2]);     // Smallest index tie-breaker
        });

        int[] result = new int[n];
        int resultIndex = 0;
        int taskIndex = 0;
        long currTime = 0; // Use long to prevent potential integer overflow

        while (resultIndex < n) {
            // If CPU is idle and heap is empty, jump time to next available task's enqueue time
            if (minHeap.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                currTime = sortedTasks[taskIndex][0];
            }

            // Push all tasks that have arrived up to current time
            while (taskIndex < n && sortedTasks[taskIndex][0] <= currTime) {
                minHeap.offer(sortedTasks[taskIndex]);
                taskIndex++;
            }

            // Process the top task from heap
            int[] currentTask = minHeap.poll();
            currTime += currentTask[1];
            result[resultIndex++] = currentTask[2];
        }

        return result;
    }
}