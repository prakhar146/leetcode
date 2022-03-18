class Solution {
    public String removeDuplicateLetters(String s) {
        // System.out.println("-------------------------");
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        // System.out.println(Arrays.toString(cnt));
        // Stack<Character> st = new Stack<>();
        // int ptr = 0;
        
        // StringBuilder sb = new StringBuilder(s);
        // int left = 0;
        // int right = 0;
        // while(right < s.length()) {
        //     if(left == right) {
        //         cnt[s.charAt(right) - 'a']--;
        //         right++;
        //     } else {
        //         if(s.charAt(left) < s.charAt(right)) {
        //             cnt[s.charAt(right) - 'a']--;
        //             right++;
        //         } else {
        //             if(cnt[s.charAt(left) - 'a'] > 0) {
        //                 sb.setCharAt(left, '#');
        //             }
        //             left++;
        //         }
        //     }
        // }
        
        Stack<Character> st = new Stack<>();
        int ptr = 0;
        int[] currentCnt = new int[26];
        while(ptr < s.length()) {
            char c = s.charAt(ptr);
            if(currentCnt[c - 'a'] > 0) {
                ptr++;
                cnt[c - 'a']--;
                continue;
            }
            if(st.empty() || (st.peek() < c)) {
                // System.out.println(Arrays.toString(cnt));
                // System.out.println("Push 1 " + c);
                st.push(c);
                cnt[c - 'a']--;
                currentCnt[c - 'a']++;
                ptr++;
            } else {
                char top = st.peek();
                // System.out.println("top -> " + top + " cnt -> " + cnt[top - 'a']);
                if(cnt[top - 'a'] > 0) {
                    // System.out.println(Arrays.toString(cnt));
                    st.pop();
                    // System.out.println("Pop " + st.pop());
                    currentCnt[top - 'a'] = 0;
                } else {
                    // System.out.println(Arrays.toString(cnt));
                    // System.out.println("Push 2 " + c);
                    st.push(c);
                    cnt[c - 'a']--;
                    currentCnt[c - 'a']++;
                    ptr++;
                }
            }
        }
        
        StringBuilder sb2 = new StringBuilder();

        while(st.size() > 0) {
            sb2.append(st.pop());
        }
        sb2.reverse();
        return sb2.toString();
    }
}