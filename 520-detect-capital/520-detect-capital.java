class Solution {
    public boolean detectCapitalUse(String word) {
        int smallCnt = 0;
        int capitalCnt = 0;
        
        for(int i = 0; i < word.length(); i++) {
            int charNum = (int) word.charAt(i);
            if(charNum > 96) {
                if(capitalCnt > 1) {
                    return false;
                }
                smallCnt++;
            } else {
                if(smallCnt > 0) {
                    return false;
                }
                capitalCnt++;
            }
        }
        return true;
    }
}