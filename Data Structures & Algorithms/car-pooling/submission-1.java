
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Sort trips by pickup location ('from')
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        // Min-heap ordered by drop-off location ('to'): stores [to, numPassengers]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int currentPassengers = 0;

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            // Drop off passengers whose destination is <= current pickup location
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= from) {
                currentPassengers -= minHeap.poll()[1];
            }

            // Pick up current passengers
            currentPassengers += numPassengers;

            if (currentPassengers > capacity) {
                return false;
            }

            minHeap.offer(new int[]{to, numPassengers});
        }
        return true;
    }
}