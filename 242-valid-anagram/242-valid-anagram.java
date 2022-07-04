class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for(char c: s.toCharArray()) {
            if(!m.containsKey(c)) {
                m.put(c, 0);
            }
            int currentCnt = m.get(c);
            currentCnt++;
            m.put(c, currentCnt);
        }
        
        for(char c: t.toCharArray()) {
            if(!m.containsKey(c)) {
                return false;
            }
            int currentCnt = m.get(c);
            currentCnt--;
            m.put(c, currentCnt);
            if(currentCnt == 0) {
                m.remove(c);
            }
        }
        
        return (m.size() == 0);
    }
}