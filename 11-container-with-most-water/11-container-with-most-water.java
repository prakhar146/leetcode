class Solution {
    public int maxArea(int[] height) {
        return solution2(height);
        // int l = 0, r = 0;
        // int maxAns = -1, currentAns = -1;
        // while(r < height.length) {
        //     if(l == r) {
        //         r++;
        //     } else {
        //         if(height[l] < height[r]) {
        //             currentAns = (r - l) * (Math.min(height[r], height[l]));
        //             maxAns = Math.max(currentAns, maxAns);
        //             l = r;
        //         } else {
        //             r++;
        //         }
        //     }
        // }
        // if(height[l] >= height[r - 1]) {
        //     currentAns = ((r - 1) - l) * (Math.min(height[l], height[r - 1]));
        //     maxAns = Math.max(currentAns, maxAns);
        // }
        // return maxAns;
    }
    
    int solution2(int height[]) {
        int l = 0;
        int r = height.length - 1;
        int currentAns = -1, maxAns = -1;
        
        while(l < r) {
            currentAns = (r - l) * Math.min(height[l], height[r]);
            maxAns = Math.max(currentAns, maxAns);
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        
        return maxAns;
    }
}