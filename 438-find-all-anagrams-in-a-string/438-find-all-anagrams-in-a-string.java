class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIdx = new ArrayList<>();
        if(s.length() < p.length()) {
            return anagramIdx;
        }
        Map<Character, Integer> pMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            if(pMap.containsKey(p.charAt(i))) {
                pMap.put(p.charAt(i), pMap.get(p.charAt(i)) + 1);
            } else {
                pMap.put(p.charAt(i), 1);
            }
        }
        
        int left = 0;
        int right = p.length() - 1;
        
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = left; i < right; i++) {
            if(sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }
        
        while(right < s.length()) {
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            // System.out.println("WINDOW: LEFT -> " + left + "; RIGHT -> " + right);
            // printMap(sMap, "sMap");
            // printMap(pMap, "pMap");
            if(pMap.equals(sMap)) {
                anagramIdx.add(left);
            }
            sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
            if(sMap.get(s.charAt(left)) < 1) {
                sMap.remove(s.charAt(left));
            }
            left++;
            right++;
        }
        
        return anagramIdx;
    }
    
    void printMap(Map<Character, Integer> m, String name) {
        System.out.println("--------" + name + "----------");
        for(Character c: m.keySet()) {
            System.out.println(c + " -> " + m.get(c));
        }
    }
}