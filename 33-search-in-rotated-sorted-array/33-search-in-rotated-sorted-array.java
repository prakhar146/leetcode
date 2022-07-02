class Solution {
    public int search(int[] nums, int target) {        
        int pivot = getPivot(nums);
        // System.out.println("Pivot " + pivot);
        int left = pivot;
        int right = pivot + nums.length;
        
        while(left < right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid % nums.length];
            // System.out.println("left " + left + " right " + right + " mid " + midNum);
            if(midNum == target) {
                return (mid % nums.length);
            }
            if(midNum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return -1;
    }
    
    int getPivot(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        if(nums[n - 1] >= nums[0]) {
            return 0;
        }
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            int midNum = nums[mid];
            
            if(midNum > nums[left] && midNum > nums[right]) {
                left = mid + 1;
                continue;
            }
            if(midNum < nums[left] && midNum < nums[right]) {
                right = mid;
                continue;
            }
            if(midNum >= nums[left] && midNum <= nums[right]) {
                right = left;
                continue;
            }
            if(midNum <= nums[left] && midNum >= nums[right]) {
                left = right;
                continue;
            }
        }
        mid = (left + right) / 2;
        
        return mid;
    }
}