class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }

      int ptr1 = 0;
        int ptr2 = 0;
        int maxLength = 0;
        HashSet<Character> c = new HashSet<>();

        while (ptr2 < s.length()) {
            if (!c.contains(s.charAt(ptr2))) {
                c.add(s.charAt(ptr2));
                ptr2++;
            } else {
                int currentLength = ptr2 - ptr1;
                maxLength = Math.max(currentLength, maxLength);
                c.remove(s.charAt(ptr1));
                ptr1++;
            }
        }

        int currentLength = ptr2 - ptr1;
        maxLength = Math.max(currentLength, maxLength);

        return maxLength;
    }
}