class Solution {
    public int[] countBits(int n) {
        int[] setBits = new int[n + 1];
        int twoPower = 0, diff = 0;
        int numOfSetBits = 0;
        setBits[0] = 0;
        for(int i = 1; i <= n; i++) {
            twoPower = (int) (Math.log(i) / Math.log(2));
            diff = i - ((int) Math.pow(2, twoPower));
            numOfSetBits = 1 + setBits[diff];
            setBits[i] = numOfSetBits;
        }
        
        return setBits;
    }
}