class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length;
        int ans = 0;
        while(l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for(int i: nums) {
                if(i <= mid) {
                    cnt++;
                }
            }
            
            if(cnt > mid) {
                ans = mid;
                r = mid - 1; 
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }
}