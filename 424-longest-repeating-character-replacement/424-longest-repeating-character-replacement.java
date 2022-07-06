class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] chars = new int[26];
        int l = 0;
        int maxAns = 0;
        int maxF = 0;
        for(int r = 0; r < N; r++) {
            chars[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, chars[s.charAt(r) - 'A']);
            int size = r + 1 - l;
            int reqK = size - maxF;
            while(reqK > k) {
                chars[s.charAt(l) - 'A']--;
                l++;
                size = r + 1 - l;
                reqK = size - maxF;
            }
            maxAns = Math.max(maxAns, size);
        }
        
        return maxAns;
    }
}