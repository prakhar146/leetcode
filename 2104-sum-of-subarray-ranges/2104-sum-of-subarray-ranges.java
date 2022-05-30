class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        // for(int i = 0; i < n; i++) {
        //     for(int j = i; j < n; j++) {
        //         int[] subset = Arrays.copyOfRange(nums, i, j + 1);
        //         int min = subset[0], max = subset[0];
        //         for(int k = 0; k < subset.length; k++) {
        //             min = Math.min(subset[k], min);
        //             max = Math.max(subset[k], max);
        //         }
        //         System.out.println("Subset " + Arrays.toString(subset) + " min " + min + " max " + max);
        //     }
        // }
        
        
        long sum = 0;
        for(int i = 0; i < n; i++) {
            int min = nums[i], max = nums[i];
            for(int j = i; j < n; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                sum += (max - min);
            }
        }
        
        return sum;
    }
}