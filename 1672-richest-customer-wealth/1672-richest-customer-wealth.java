class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] amounts: accounts) {
            max = Math.max(max, findSum(amounts));
        }
        return max;
    }
    
    int findSum(int[] amounts) {
        int sum = 0;
        for(int n: amounts) {
            sum += n;
        }
        return sum;
    }
}