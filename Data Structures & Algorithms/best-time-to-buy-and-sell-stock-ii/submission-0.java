class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        // Loop 1st index se start hoga kyunki hum pichle din (i-1) se compare kar rahe hain
        for (int i = 1; i < prices.length; i++) {
            // Agar aaj ki price kal se zyada hai, to profit book kar lo
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}