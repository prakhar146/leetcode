class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for(int num: nums) {
            ans = Math.max(ans, num);
        }
        int currentMax = 1, currentMin = 1;
        for(int num: nums) {
            if(num == 0) {
                currentMax = 1; 
                currentMin = 1;
                continue;
            }
            int tmp = Math.max(num, Math.max(currentMax * num, currentMin * num));
            currentMin = Math.min(num, Math.min(currentMax * num, currentMin * num));
            currentMax = tmp;
            // System.out.println("num: " + num + " cMax " + currentMax + " cMin " + currentMin);
            ans = Math.max(ans, currentMax);
        }
        
        return ans;
    }
}