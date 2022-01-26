class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 1;
        int maxCnt = 0;
        int currentCnt;
        
        int sign = 0;
        int diff;
        
        while(right < arr.length) {
            diff = arr[right] - arr[right - 1];
            if(diff == 0 || (diff > 0 && sign > 0) || (diff < 0 && sign < 0)) {
                currentCnt = right - left;
                maxCnt = Math.max(currentCnt, maxCnt);
                left = diff != 0 ? right - 1 : right;   
            }
            sign = diff > 0 ? 1 : -1;
            right++;
        }
        
        currentCnt = right - left;
        maxCnt = Math.max(currentCnt, maxCnt);
        
        return maxCnt;
    }
}