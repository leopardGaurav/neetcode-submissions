public class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        // 1. Pehle saare rangon ko gino
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            else if (nums[i] == 1) count1++;
            else if (nums[i] == 2) count2++;
        }
        
        // 2. Ab array ko sahi order mein overwrite (dobara bharo) karo
        int index = 0;
        
        // Pehle saare 0 bharo
        while (count0 > 0) {
            nums[index++] = 0;
            count0--;
        }
        // Phir saare 1 bharo
        while (count1 > 0) {
            nums[index++] = 1;
            count1--;
        }
        // Aakhiri mein saare 2 bharo
        while (count2 > 0) {
            nums[index++] = 2;
            count2--;
        }
    }
}