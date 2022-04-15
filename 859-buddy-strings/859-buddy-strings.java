class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        List<Character> mismatchList = new ArrayList<>();
        boolean hasDuplicate = false;
        Map<Character, Boolean> dupMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = goal.charAt(i);
            if(!dupMap.containsKey(c1)) {
                dupMap.put(c1, true);
            } else {
                hasDuplicate = true;
            }
            
            if(c1 != c2) {
                mismatchList.add(c1);
                mismatchList.add(c2);
                if(mismatchList.size() > 2) {
                    char sOld = mismatchList.get(0);
                    char gOld = mismatchList.get(1);
                    // System.out.println("c1 -> " + c1 + " gOld -> " + gOld);
                    // System.out.println("c2 -> " + c2 + " sOld -> " + sOld);
                    if(sOld != c2 || gOld != c1) {
                        return false;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(mismatchArray));
        // if(mismatchArray[0] == 1) {
        //     System.out.println("TRUE!!!");
        // }
        return (mismatchList.size() == 4 || (mismatchList.size() == 0 && hasDuplicate));
    }
}