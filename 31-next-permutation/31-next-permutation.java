class Solution {
    public void nextPermutation(int[] nums) { 
        int ptr = getPtOfChange(nums);
        if(ptr > -1) {
            Arrays.sort(nums, ptr, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
    
    int getPtOfChange(int[] nums) {
        
        int ptr = -1;
        int currentAns = Integer.MAX_VALUE;
        int l = -1;
        int r = -1;
        int n = nums.length - 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = (i + 1); j <= n; j++) {
                if(nums[j] > nums[i]) {
                    if(l != i) {
                        currentAns = Integer.MAX_VALUE;
                    }
                    // System.out.println("nums[" + j + "] -> " + nums[j] + " nums[" + i + "] -> " + nums[i]);
                    if(nums[j] < currentAns) {
                        l = i;
                        r = j;
                        currentAns = nums[j];
                        // System.out.println("nums[" + j + "] -> " + nums[j] + " nums[" + i + "] -> " + nums[i] + " l -> " + l + " r ->" + r);
                    }
                }
            }
        }
        if(l > -1) {
            swap(nums, l, r);   
            ptr = l + 1;
        }
        return ptr;
    }
    
    void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}

/*
Expected
1,2,3
1,3,2
2,1,3
2,3,1
3,2,1

1,2,3
1,

2,4,5,1,2,3,2,1
2,4,5,2,2,3,1,1        


*/