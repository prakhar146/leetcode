class Solution {
    public String getSmallestString(int n, int k) {
        int maxPossibleAns = n * 26;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        
        while(idx < n) {
            for(int i = 1; i < 27; i++) {
                if((maxPossibleAns - (26 - i)) >= k) {
                    sb.append((char)((int)'a' + (i - 1)));
                    maxPossibleAns -= (26 - i);
                    break;
                }
            }
            idx++;
        }
        
        return sb.toString();
    }
}