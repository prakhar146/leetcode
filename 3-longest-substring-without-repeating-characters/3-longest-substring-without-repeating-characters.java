class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }

     int ptr1 = 0;
        int ptr2 = 0;
        int currentLength = 0;
        int maxLength = 0;

        Map<Character, Integer> cWithIdx = new HashMap<>();

        while (ptr2 < s.length()) {
            if (cWithIdx.containsKey(s.charAt(ptr2))) {
                // Update ptr1
                ptr1 = Math.max(cWithIdx.get(s.charAt(ptr2)) + 1, ptr1);
            }
            cWithIdx.put(s.charAt(ptr2), ptr2);
            currentLength = ptr2 - ptr1 + 1;
            maxLength = Math.max(currentLength, maxLength);
            ptr2++;
        }

        return maxLength;
    }
}