class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int left = -1;
        int right = -1;
        
        // float up
        // int maxNum = nums[N - 1];
        for(int i = (N - 1); i > -1; i--) {
            int min = 101;
            for(int j = i; j < N; j++) {
                // System.out.println("i -> " + i + " j -> " + j + " nums[" + i + "] -> " + nums[i] + " nums[" + j + "] -> " + nums[j]);
                if(nums[j] > nums[i] && nums[j] < min) {
                    left = i;
                    right = j;
                    min = nums[j];
                    // break;
                }
            }
            if(left > -1 && right > -1) {
                break;
            }
        }
        // System.out.println("left -> " + left + " right -> " + right);
        if(left > -1 && right > -1) {
            swap(nums, left, right);
            Arrays.sort(nums, left + 1, N);   
        } else {
            Arrays.sort(nums);
        }
    }
    
    void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}