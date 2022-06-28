class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int tmpSum = sum + nums[i];
            if(tmpSum < 0) {
                sum = 0;
            } else {
                sum = tmpSum;
                maxSum = Math.max(maxSum, sum);
            }
            maxSum = Math.max(maxSum, nums[i]);   
        }
        // maxSum = Math.max(maxSum, sum);
        return maxSum;
    }
}