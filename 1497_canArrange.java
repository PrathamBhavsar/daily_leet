class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        
        // Count the remainder frequencies
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;  // Make sure remainder is non-negative
            remainderCount[remainder]++;
        }
        
        // Check if pairs can be made
        for (int i = 1; i < k; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }
        
        // Special case for remainder 0
        if (remainderCount[0] % 2 != 0) {
            return false;
        }
        
        return true;
    }
}
