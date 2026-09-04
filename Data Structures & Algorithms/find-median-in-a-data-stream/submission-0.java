
class MedianFinder {
    // Max-Heap to store the smaller half of numbers
    private PriorityQueue<Integer> small;
    // Min-Heap to store the larger half of numbers
    private PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    public void addNum(int num) {
        // Step 1: Add to max-heap (small)
        small.offer(num);
        // Step 2: Make sure every element in small <= every element in large
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }
        // Step 3: Handle size imbalance (small can have at most 1 extra element)
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }
    public double findMedian() {
        if (small.size() > large.size()) {
            return (double) small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}