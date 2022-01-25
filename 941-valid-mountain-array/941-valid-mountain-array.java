class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean increasing = false;
        boolean decreasing = false;
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i - 1]) {
                if(decreasing) {
                    return false;
                }
                increasing = true;
            } else if (arr[i] == arr[i - 1]) {
                return false;
            } else {
                if(!increasing) {
                    return false;
                }
                    
                decreasing = true;
            }
        }
        
        return decreasing;
        
    }
}