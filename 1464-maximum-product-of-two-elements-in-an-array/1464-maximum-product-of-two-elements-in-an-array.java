class Solution {
    public int maxProduct(int[] nums) {
        int maxIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int maxProduct = nums[maxIdx] - 1;
        for(int i = 0; i < nums.length; i++) {
            if(i != maxIdx) {
                maxProduct = Math.max(maxProduct,((nums[maxIdx] - 1) * (nums[i] - 1)));
            }
        }
        return maxProduct;
    }
}