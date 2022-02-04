class Solution {
    public int findMaxLength(int[] nums) {
        int tmpSum = 0;
        int maxLength = 0;
        int offset = nums.length;
        
        int[] idxStore = new int[(2 * nums.length) + 1];
        for(int i = 0; i < idxStore.length; i++) {
            idxStore[i] = -1;
        }
        
        // System.out.println(Arrays.toString(idxStore));
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                tmpSum++;
            } else {
                tmpSum--;
            }
            if(tmpSum == 0) {
                setIdx(tmpSum, i, idxStore, offset);
            }
            int idx = getIdx(tmpSum, idxStore, offset);
            // System.out.println("getting idx for -> " + tmpSum + " idx -> " + idx);
            if(idx > -1) {
                maxLength = Math.max(maxLength, i - idx);
            } else {
                setIdx(tmpSum, i, idxStore, offset);
                // System.out.println(Arrays.toString(idxStore));
            }
        }
        
        return Math.max(maxLength, 1 + getIdx(0, idxStore, offset));
    }
    
    int getIdx(int tmpSum, int[] idxStore, int offset) {
        return idxStore[offset + tmpSum];
    }
    
    void setIdx(int tmpSum, int idx, int[] idxStore, int offset) {
        idxStore[offset + tmpSum] = idx;
    }
}