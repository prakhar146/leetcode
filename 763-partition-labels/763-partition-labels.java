class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, List<Integer>> idxMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!idxMap.containsKey(c)) {
                idxMap.put(c, new ArrayList<>());
            }
            List<Integer> cl = idxMap.get(c);
            if(cl.size() < 1) {
                cl.add(i);
            }
            if(cl.size() < 2) {
                cl.add(i);
            }
            if(cl.size() == 2) {
                cl.set(1, i);
            }
            idxMap.put(c, cl);
        }
        
        int ptr = 0;
        List<Integer> partitions = new ArrayList<>();
        while(ptr < s.length()) {
            char c = s.charAt(ptr);
            List<Integer> range = idxMap.get(c);
            int l = range.get(0);
            int r = range.get(1);
            while(l < r) {
                c = s.charAt(l);
                r = Math.max(r, idxMap.get(c).get(1));
                l++;
            }
            partitions.add(r - range.get(0) + 1);
            ptr = r + 1;
        }
        
        return partitions;
    }
}