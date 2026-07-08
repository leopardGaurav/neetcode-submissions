class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // Step 1: Left (Prefix) Product कैलकुलेट करें
        // हर इंडेक्स पर उसके लेफ्ट वाले एलिमेंट्स का प्रोडक्ट स्टोर होगा
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i]; // अगले इंडेक्स के लिए करंट नंबर को मल्टीप्लाई कर लें
        }
        
        // Step 2: Right (Suffix) Product को उसी में मल्टीप्लाई करते जाएं
        // पीछे से लूप चलाएंगे और राइट प्रोडक्ट का हिसाब रखेंगे
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct; // पहले से मौजूद लेफ्ट प्रोडक्ट में राइट प्रोडक्ट को मल्टीप्लाई किया
            rightProduct *= nums[i];   // अगले इंडेक्स के लिए करंट नंबर को मल्टीप्लाई कर लें
        }
        
        return output;
    }
}