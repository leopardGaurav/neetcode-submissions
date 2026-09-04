class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        // Add initial elements to the min-heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // Push the new value into the heap
        minHeap.offer(val);

        // If the heap size exceeds k, pop the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}