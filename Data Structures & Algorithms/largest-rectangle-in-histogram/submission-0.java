class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // Stack stores pairs: [start_index, height]
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            // Maintain monotonic increasing stack
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] popped = stack.pop();
                int index = popped[0];
                int height = popped[1];
                
                // Calculate max area bounded by the popped height
                maxArea = Math.max(maxArea, height * (i - index));
                
                // Current bar can extend backwards to where popped bar started
                start = index;
            }

            stack.push(new int[]{start, heights[i]});
        }

        // Evaluate rectangles that extend all the way to the end of the histogram
        int n = heights.length;
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            maxArea = Math.max(maxArea, popped[1] * (n - popped[0]));
        }

        return maxArea;
    }
}