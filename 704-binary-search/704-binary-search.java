class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s <= e) {            
            int mid = (s + e) / 2;
            int midValue = nums[mid];
            if(midValue == target) {
                return mid;
            }
            if(midValue > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        return -1;
    }
}