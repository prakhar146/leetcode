class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 2; j < nums.length; j++) {
                if(isArithmaticSubarray(nums, i, j)) {
                  cnt++;  
                }
            }
        }
        
        return cnt;
    }
    
    boolean isArithmaticSubarray(int[] nums, int s, int e) {
        int prevDiff = nums[s + 1] - nums[s];
        int currentDiff = 0;
        for(int i = (s + 1); i < e; i++){
            currentDiff = nums[i + 1] - nums[i];
            if(currentDiff != prevDiff) {
                return false;
            }
        }
        
        return true;
    }
}