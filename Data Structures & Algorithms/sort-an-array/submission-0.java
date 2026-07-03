class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Step 1: Diye gaye array ko Max-Heap mein convert karein
        // Hum n/2 - 1 se shuru karte hain kyunki aakhiri non-leaf node yahin hota hai
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyIterative(nums, n, i);
        }

        // Step 2: Ek-ek karke element ko heap se nikal kar sort karein
        for (int i = n - 1; i > 0; i--) {
            // Sabse bade element (nums[0]) ko aakhiri unsorted position (nums[i]) par bhejein
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Bache hue elements par fir se heapify chalayein (ab heap ka size 'i' ho gaya hai)
            heapifyIterative(nums, i, 0);
        }

        return nums;
    }

    // Iterative Heapify: Yeh bina recursion ke max-heap property ko maintain karta hai
    private void heapifyIterative(int[] nums, int n, int i) {
        int largest = i;

        while (true) {
            int left = 2 * largest + 1;  // Left child ka index
            int right = 2 * largest + 2; // Right child ka index
            int currentLargest = largest;

            // Agar left child bada hai
            if (left < n && nums[left] > nums[currentLargest]) {
                currentLargest = left;
            }

            // Agar right child bada hai
            if (right < n && nums[right] > nums[currentLargest]) {
                currentLargest = right;
            }

            // Agar largest change hua hai, toh swap karein aur loop ko aage badhayein
            if (currentLargest != largest) {
                int swap = nums[largest];
                nums[largest] = nums[currentLargest];
                nums[currentLargest] = swap;

                // Naye index par check karne ke liye largest ko update karein
                largest = currentLargest;
            } else {
                // Agar sab sahi hai, toh loop se bahar nikal jayein
                break;
            }
        }
    }
}