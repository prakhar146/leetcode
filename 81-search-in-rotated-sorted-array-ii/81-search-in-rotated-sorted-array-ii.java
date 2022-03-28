class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = getPivot(nums);
        // System.out.println("pivot " + pivot);
        return binarySearch(nums, pivot, target);
    }
    
    int getPivot(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                return i;
            }
        }
        return 0;
//         int s = 0;
//         int e = nums.length;
        
//         while(s < e) {
//             int mid = (s + e) / 2;
//             if(nums[mid] > nums[s]) {
//                 s = mid;
//             } else {
//                 e = mid;
//             }
//         }
        
//         return s + 1;
    }
    
    boolean binarySearch(int[] nums, int startIdx, int target) {
        int l = startIdx;
        int e = l + nums.length - 1;
        
        while(l <= e) {
            int mid = (l + e) / 2;
            int midNum = nums[mid % nums.length];
            // System.out.println("left " + l + " end " + e + " mid " + mid + " midnum " + midNum);
            if(midNum == target) {
                return true;
            }
            if(midNum > target) {
                e = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return false;
    }
}