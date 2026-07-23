class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Pehle minPrice ko sabse bada value set kar do
        int maxProfit = 0;               // Maximum profit default 0 rakhenge

        for (int i = 0; i < prices.length; i++) {
            // Step 1: Agar aaj ka price purane minPrice se kam hai, toh buy price update karo
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Step 2: Warna check karo ki aaj sell karne par kitna profit mil raha hai
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}