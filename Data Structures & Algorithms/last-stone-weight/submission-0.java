

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a Max-Heap using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to the max-heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Simulate smashing until 1 or 0 stones remain
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Heaviest stone
            int x = maxHeap.poll(); // Second heaviest stone

            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        // Return remaining stone weight or 0 if heap is empty
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}