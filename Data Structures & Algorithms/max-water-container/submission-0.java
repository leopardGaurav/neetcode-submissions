class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Width calculate karo
            int width = right - left;
            
            // Paani chhote bar ke height tak hi rahega
            int minHeight = Math.min(heights[left], heights[right]);
            
            // Current area calculate karke maxWater update karo
            int currentWater = width * minHeight;
            maxWater = Math.max(maxWater, currentWater);

            // Chhote bar ko move karo
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}