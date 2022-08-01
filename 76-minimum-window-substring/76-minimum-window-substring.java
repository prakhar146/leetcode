class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        loadMap(t, tMap);
        
        int S = s.length();
        int T = t.length();
        
        int left = 0;
        int right = 0;
        
        String minString = "";
        int minLength = Integer.MAX_VALUE;
        
        int matchCnt = 0;
        
        while(right < S) {
            char c = s.charAt(right);
            if(tMap.containsKey(c)) {
                int currentCnt = tMap.get(c);
                currentCnt++;
                tMap.put(c, currentCnt);
                if(currentCnt < 1) {
                    matchCnt++;
                }
            }
            if(matchCnt == T) {
                while(matchCnt == T) {
                    // System.out.println("match left -> " + left + " right -> " + right);
                    int currentSize = right + 1 - left;
                    if(currentSize < minLength) {
                        minString = s.substring(left, right + 1);
                        minLength = currentSize;
                    }
                    char leftChar = s.charAt(left);
                    if(tMap.containsKey(leftChar)) {
                        int currentCnt = tMap.get(leftChar);
                        currentCnt--;
                        tMap.put(leftChar, currentCnt);
                        if(currentCnt < 0) {
                            matchCnt--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        return minString;
        
    }
    
    void loadMap(String s, Map<Character, Integer> map) {
        for(char c: s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            int currentCnt = map.get(c);
            currentCnt--;
            map.put(c, currentCnt);
        }
    }
        
}