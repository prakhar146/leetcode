class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int currentMax = height[0];
        for(int i = 1; i < n; i++) {
            leftMax[i] = currentMax;
            currentMax = Math.max(currentMax, height[i]);
        }
        
        currentMax = height[n - 1];
        for(int i = (n - 2); i > -1; i--) {
            rightMax[i] = currentMax;
            currentMax = Math.max(currentMax, height[i]);
        }
        int waterCollected = 0;
        
        for(int i = 0; i < n; i++) {
            int currentH = height[i];
            int sideSupport = Math.min(leftMax[i], rightMax[i]);
            int water = sideSupport - currentH;
            if(water > 0) {
                waterCollected += water;
            }
        }
        
        return waterCollected;
    }
}