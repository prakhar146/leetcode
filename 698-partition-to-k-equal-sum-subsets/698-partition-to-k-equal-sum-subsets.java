class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = totalSum(nums);
        if(sum % k != 0) {
            return false;
        }
        int N = nums.length;
        int target = sum / k;
        // int[][] dp = new int[N][target + 1];
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j <= target; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        boolean[] used = new boolean[N];
        // for(int i = 0; i < N; i++) {
        //     used[i] = false;
        // }
        // List<Integer> list = new ArrayList<>();
        // int totalSubsets = getTargetSum(nums, target, 0, dp, list, used);
        // System.out.println("target -> " + target);
        boolean ans = canPartition(nums, target, 0, used, k, 0);
        // for(int i = 0; i < N; i++) {
        //     if(!used[i]) {
        //         totalSubsets += getTargetSum(nums, target, i, dp, list, used);
        //     }
        // }
        // System.out.println("Total Subsets " + totalSubsets);
        return ans;
        
    }
    
    boolean canPartition(int[] nums, int target, int idx, boolean[] used, int k, int currentSize) {
        if(k == 0) {
            return true;
        }
        if(target == currentSize) {
            // System.out.println(subset + " k " + k);
            // subset.clear();
            // System.out.println("used " + Arrays.toString(used));
            return canPartition(nums, target, 0, used, k - 1, 0);
        }
        if(idx >= nums.length || currentSize > target) {
            return false;
        }
        // if(dp[idx][currentSize] != -1) {
        //     return dp[idx][currentSize] == 1 ? true : false;
        // }
        int max = 0;
        boolean can = false;
        for(int i = idx; i < nums.length; i++) {
            if(!used[i]) {
                // subset.add(nums[i]);
                used[i] = true;
                if(((currentSize + nums[i]) <= target) && canPartition(nums, target, i + 1, used, k, currentSize + nums[i])) {
                    return true;
                }
                // if(!subset.isEmpty()) {
                //     subset.remove(subset.size() - 1);
                // }
                used[i] = false;
                // if(op1 < 1) {
                //     used[idx] = false;
                // }
            }
        }
        // int op1 = 0;
        // if(!used[idx]) {
        //     subset.add(nums[idx]);
        //     used[idx] = true;
        //     op1 = getTargetSum(nums, target - nums[idx], idx + 1, dp, subset, used);  
        //     subset.remove(subset.size() - 1);
        //     if(op1 < 1) {
        //         used[idx] = false;
        //     }
        // }
        // int op2 = getTargetSum(nums, target, idx + 1,  dp, subset, used);
        // int ans = op1 + op2;
        // dp[idx][currentSize] = can ? 1 : 0;
        return can;
    }
    
    int totalSum(int[] arr) {
        int sum = 0;
        for(int i: arr) {
            sum += i;
        }
        return sum;
    }
}