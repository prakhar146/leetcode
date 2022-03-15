class Solution {
    class BracketPair {
        char c;
        int idx;
        
        BracketPair(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }
    public String minRemoveToMakeValid(String s) {
        Stack<BracketPair> st = new Stack<>();
        int ptr = 0;
        while(ptr < s.length()) {
            char c = s.charAt(ptr);
            if(c == '(' || c == ')') {
                if(st.empty()) {
                    st.push(new BracketPair(c, ptr));
                } else {
                    if(c == ')' && st.peek().c == '(') {
                        st.pop();
                    } else {
                        st.push(new BracketPair(c, ptr));
                    }
                }
                
            }
            ptr++;
        }
        
        if(st.isEmpty()) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        ptr = s.length() - 1;
        while(ptr > -1) {
            char c = s.charAt(ptr);
            if(!st.empty() && c == st.peek().c && ptr == st.peek().idx) {
                st.pop();
            } else {
                sb.append(c);
            }
            ptr--;
        }
        return sb.reverse().toString();
        
    }
}