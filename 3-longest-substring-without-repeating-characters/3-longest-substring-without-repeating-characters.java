class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }

        int ptr1 = 0;
        int ptr2 = 0;
        int currentLength = 0;
        int maxLength = 0;
        boolean[] exists = new boolean[26];
        // exists[s.charAt(0) - 97] = true;
        String maxLengthSubstring = "";

         Map<Character, Boolean> existMap = new HashMap<>();
        existMap
                .put(s.charAt(ptr1), true);

        while (ptr1 <= ptr2 && ptr2 < s.length()) {
            if (ptr1 == ptr2) {
                ptr2++;
                continue;
            }
            if (existMap.containsKey(s.charAt(ptr2))) {
                currentLength = ptr2 - ptr1;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxLengthSubstring = s.substring(ptr1, ptr2);
                }
//                exists = new boolean[26];
                existMap.clear();
                ptr1++;
//                exists[s.charAt(ptr1) - 97] = true;
                existMap
                        .put(s.charAt(ptr1), true);
                ptr2 = ptr1;
            } else {
//                exists[s.charAt(ptr2) - 97] = true;
                existMap
                        .put(s.charAt(ptr2), true);
                ptr2++;
            }
        }

        currentLength = ptr2 - ptr1;
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxLengthSubstring = s.substring(ptr1, ptr2);
        }


        return maxLengthSubstring.length();
    }
}