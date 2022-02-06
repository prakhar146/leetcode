class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int freq = 1;
        int bMark = -1;
        
        printArray(nums, "initially");
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == prev) {
                if(freq < 2) {
                    freq++;
                } else if (bMark < 0) {
                    bMark = i;
                } else {
                    continue;
                }
            } else {
                freq = 1;
                prev = nums[i];
            }
            if(bMark > -1 && bMark != i) {
                swap(nums, i, bMark);
                if(nums[i] != prev) {
                  bMark++;  
                } 
            }
        }
        
        printArray(nums, "finally");
        return bMark > 0 ? bMark : nums.length;
    }
    
    void printArray(int[] nums, String label) {
         System.out.println("----------" + label + "----------");
        System.out.println(Arrays.toString(nums));
        // System.out.println("----------" + label + "----------");
    }
    
    void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}