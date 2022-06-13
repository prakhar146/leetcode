class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        int[] prefixProduct = new int[n];
        prefixProduct[0] = 1;
        int[] suffixProduct = new int[n];
        suffixProduct[n - 1] = 1;
        
        loadPrefixSum(prefixProduct, nums);
        loadSuffixSum(suffixProduct, nums);
        
        int[] productArr = new int[n];
        for(int i = 0; i < n; i++) {
            productArr[i] = prefixProduct[i] * suffixProduct[i];
        }
        return productArr;
    }
    
    void loadPrefixSum(int[] prefixProduct, int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
    }
    
    void loadSuffixSum(int[] suffixProduct, int[] nums) {
        int n = nums.length;
        for(int i = (n - 2); i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
    }
}