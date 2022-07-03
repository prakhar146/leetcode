class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxWater = 0;
        while(left < right) {
            int w = (right - left);
            int h = Math.min(height[right], height[left]);
            int currentArea = h * w;
            maxWater = Math.max(currentArea, maxWater);
            if(height[right] > height[left]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        
        return maxWater;
    }
    
    int codeBlock(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for(int i = (n - 2); i > -1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        
        int maxWater = 0;
        for(int i = 0; i < n; i++) {
            maxWater += Math.min(leftMax[i], rightMax[i]);
        }
        return maxWater;
    }
}
/*

1 - (1, 1)
8
    left (0,8)
        4 -> -1
        2 -> -1
        1 -> 1
    right (0,8)
        4 -> 


*/