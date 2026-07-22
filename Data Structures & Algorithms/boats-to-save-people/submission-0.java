class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(people);
        
        int left = 0;                  // Pointer for the lightest person
        int right = people.length - 1; // Pointer for the heaviest person
        int boats = 0;
        
        while (left <= right) {
            // If the lightest and heaviest person can share a boat
            if (people[left] + people[right] <= limit) {
                left++; // Lightest person takes the boat too
            }
            
            // Heaviest person ALWAYS takes a boat (either alone or with the lightest)
            right--;
            boats++; // Increment boat count in each step
        }
        
        return boats;
    }
}