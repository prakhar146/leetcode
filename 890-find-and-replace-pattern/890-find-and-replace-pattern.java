class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Set<Character> pu = new HashSet<>();

        loadPatternUsed(pattern, pu);
        int noOfWildcards;
        List<String> matchingWords = new ArrayList<>();
        Map<Character, Character> mappingFactory = new HashMap<>();

        for (String i: words) {
            noOfWildcards = pu.size();
            mappingFactory.clear();

//            StringBuilder patternPermutation = new StringBuilder();
            StringBuilder stringPermutation = new StringBuilder();
            for (int j = 0 ; j < i.length(); j++) {

                if (!mappingFactory.containsKey(i.charAt(j)) && noOfWildcards > 0) {
                    mappingFactory.put(i.charAt(j), pattern.charAt(j));
                    noOfWildcards--;
                }
                if (mappingFactory.containsKey(i.charAt(j))) {
                    stringPermutation.append(mappingFactory.get(i.charAt(j)));
                }
            }

            if (stringPermutation.toString().equals(pattern)) {
                matchingWords.add(i);
            }
        }

        return matchingWords;   
    }
    
    void loadPatternUsed(String pattern, Set<Character> pu) {
        for (int i = 0 ; i < pattern.length(); i++) {
            pu.add(pattern.charAt(i));
        }

    }
}