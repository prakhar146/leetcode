class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String word: strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sortedWord = String.valueOf(arr);
            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList());
            }
            List<String> currentList = map.get(sortedWord);
            currentList.add(word);
        }
        
        List<List<String>> groupedAnagrams = new ArrayList<>();
        for(String w: map.keySet()) {
            groupedAnagrams.add(map.get(w));
        }
        
        return groupedAnagrams;
    }
} 