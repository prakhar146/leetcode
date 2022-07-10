class Solution {
    public int minFlipsMonoIncr(String s) {
        int N = s.length();
        int[] prefixSum = new int[N + 1];
        prefixSum[0] = 0;
        for(int i = 1; i <= N; i++) {
            char c = s.charAt(i - 1);
            int v = c - '0';
            prefixSum[i] = prefixSum[i - 1] + v;
        }
        
        // System.out.println("Prefix " + Arrays.toString(prefixSum));
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int leftOnes = prefixSum[i + 1];
            int rightZeroes = (N - 1 - i) - (prefixSum[N] - prefixSum[i]);
            int flips = leftOnes + rightZeroes;
            min = Math.min(min, flips);
        }
        
        return min;
    }
}