class Solution {
    public int splitArray(int[] nums, int m) {
        Integer[][] dp = new Integer[nums.length][m + 2];
        int[] prefixSum = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        return getMinSum(nums, 0, m, prefixSum, dp);
    }
    
    int getMinSum(int[] nums, int idx, int subCnt, int[] prefixSum, Integer[][] dp) {
        if(subCnt == 1) {
            return (prefixSum[nums.length] - prefixSum[idx]);
        }
        if(dp[idx][subCnt] != null) {
            return dp[idx][subCnt];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = idx; i <= (nums.length - subCnt); i++) {
            int op1 = prefixSum[i + 1] - prefixSum[idx]; 
            int op2 = getMinSum(nums, i + 1, subCnt - 1, prefixSum, dp);
            // System.out.println("idx " + i + " op1 " + op1 + " op2 " + op2);
            // System.out.println("dp[" + i + "][" + subCnt + "] " + op2);
            int maxPartitionSum = Math.max(op1, op2);
            ans = Math.min(ans, maxPartitionSum);
        }
        dp[idx][subCnt] = ans;
        return ans;
    }
}