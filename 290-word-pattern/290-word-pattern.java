class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] chars = pattern.split("");
        String[] words = s.split(" ");
        if (chars.length != words.length) {
            return false;
        }
        Map<String, String> charToString = new HashMap<>();
        Map<String, String> stringToChar = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (charToString.containsKey(chars[i]) && !Objects.equals(charToString.get(chars[i]), words[i])) {
                return false;
            }
            if (stringToChar.containsKey(words[i]) && !Objects.equals(stringToChar.get(words[i]), chars[i])) {
                return false;
            }
            charToString.put(chars[i], words[i]);
            stringToChar.put(words[i], chars[i]);
        }

        return true;
    }
}