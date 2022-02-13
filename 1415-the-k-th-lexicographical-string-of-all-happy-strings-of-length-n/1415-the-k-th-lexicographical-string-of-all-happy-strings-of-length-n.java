class Solution {
    public String getHappyString(int n, int k) {
        char[] charList = new char[] {'a', 'b', 'c'};
        List<String> happyStrings = new ArrayList<>();
        this.getHappyStrings(charList, new StringBuilder(), n, happyStrings);
        
        return (k <= happyStrings.size()) ? happyStrings.get(k - 1) : "";
    }
    
    private void getHappyStrings(char[] charList, StringBuilder currentString, int n, List<String> happyStrings) {
        if(currentString.length() == n) {
            happyStrings.add(new String(currentString.toString()));
            return;
        }
        
        for(int i = 0; i < charList.length; i++) {
            char tmp = charList[i];
            if(canAppend(currentString, tmp)) {
                currentString.append(tmp);
                getHappyStrings(charList, currentString, n, happyStrings);
                currentString.deleteCharAt(currentString.length() - 1);
            }
        }
    }
    
    // Happy String Logic here
    private boolean canAppend(StringBuilder str, char c) {
        int strLength = str.length();
        if(strLength == 0) {
            return true;
        }
        char lastChar = str.charAt(strLength - 1);
        return (lastChar != c);
    }
}