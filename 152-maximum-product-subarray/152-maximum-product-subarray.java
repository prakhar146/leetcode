class Solution {
    public int maxProduct(int[] nums) {
        int maxValue = nums[0];
        int minValue = nums[0];
        
        int currentMax = 1, currentMin = 1;
        
        for(int i = 0; i < nums.length; i++) {
            int v1 = currentMax * nums[i];
            int v2 = currentMin * nums[i];
            
            int tmpMax = Math.max(v1, v2);
            int tmpMin = Math.min(v1, v2);
            
            currentMax = Math.max(nums[i], tmpMax);
            currentMin = Math.min(nums[i], tmpMin);
            
            maxValue = Math.max(currentMax, maxValue);
            minValue = Math.min(currentMin, minValue);
            
            if(currentMax == 0) currentMax = 1;
            if(currentMin == 0) currentMin = 1;
        }
        
        return maxValue;
    }
}

/*
[]

nums[i] CurrMax CurrMin MaxV MinV 
            1       1     1    1
----------------------------
     2      2       2     2     2
    -5     -5      -10    2     -10
    -2     10       -2    10    -10
    -4      8      -40
    
    -2      -2      -2     -2   -2
    0       0       0       0   -2
    -1      -1      -1      0   -2    
*/