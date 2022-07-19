class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0;
        int N = s.length();
        int maxAns = 0;
        while(r < N) {
            char c = s.charAt(r);
            freq[c - 'A']++;
            
            int totalChars = r + 1 - l;
            int maxCharCnt = getMax(freq);
            int reqK = totalChars - maxCharCnt;
            while(reqK > k) {
                // System.out.print(Arrays.toString(freq));
                char leftChar = s.charAt(l);
                freq[leftChar - 'A']--;
                l++;
                totalChars = (r + 1) - l;
                maxCharCnt = getMax(freq);
                reqK = totalChars - maxCharCnt;
                // System.out.println("r -> " + r + "; l -> " + l + " reqK " + reqK + " totalChars -> " + totalChars + " maxCharCnt -> " + maxCharCnt);
            }
            
            maxAns = Math.max(maxAns, r + 1 - l);
            r++;
        }
        
        return maxAns;
    }
    
    int getMax(int[] freq) {
        int max = 0;
        for(int i: freq) {
            max = Math.max(i, max);
        }
        
        return max;
    }
}