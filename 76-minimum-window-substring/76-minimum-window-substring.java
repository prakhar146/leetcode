class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for(char c: t.toCharArray()) {
            if(!m.containsKey(c)) {
                m.put(c, 0);
            }
            int currentCnt = m.get(c);
            currentCnt--;
            m.put(c, currentCnt);
        }
        
        int leftPtr = 0;
        int rightPtr = 0;
        int minLength = Integer.MAX_VALUE;
        String minString = "";
        
        int N = s.length();
        int matchCnt = 0;
        int T = t.length();
        while(rightPtr < N) {
            char c = s.charAt(rightPtr);
            if(m.containsKey(c)) {
                int currentCnt = m.get(c);
                currentCnt++;
                m.put(c, currentCnt);
                if(currentCnt < 1) {
                    matchCnt++;   
                }
            }
            if(matchCnt == T) {
                // System.out.println("Match " + s.substring(leftPtr, rightPtr + 1) + " right " + rightPtr);
                while(matchCnt == T) {
                    int currentLength = rightPtr + 1 - leftPtr;
                    if(currentLength < minLength) {
                        minLength = currentLength;
                        minString = s.substring(leftPtr, rightPtr + 1);
                    }
                    char leftChar = s.charAt(leftPtr);
                    if(m.containsKey(leftChar)) { 
                        int currentCnt = m.get(leftChar);
                        currentCnt--;
                        // System.out.println("leftPtr " + leftPtr + " leftChar " + leftChar + " cnt " + currentCnt);
                        m.put(leftChar, currentCnt);
                        if(m.get(leftChar) < 0) {
                            matchCnt--;
                        }
                    }
                    // printMap(m);
                    leftPtr++;
                }
                // System.out.println(" --> new left " +leftPtr);
            }
            rightPtr++;
        }
        
        return minString;
    }
    
    void printMap(Map<Character, Integer> m) {
        System.out.print("[");
        for(char c: m.keySet()) {
            System.out.print(" " + c + " -> " + m.get(c));
        }
        System.out.println("]");
    }
}
/*

"ADOBECODEBANC"
"ABC"
"a"
"a"
"a"
"aa"
"ab"
"b"
"aaaaaaaaaaaabbbbbcdd"
"abcdd"

*/