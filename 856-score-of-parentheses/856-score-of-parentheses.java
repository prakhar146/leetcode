class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(0);
            } else {
                if(st.peek() == 0) {
                    st.pop();
                    int v1 = st.pop();
                    st.push(v1 + 1);
                } else {
                    int tmp = st.pop();
                    int v2 = st.pop();
                    st.push(v2 + (2 * tmp));
                }
            }
        }
        
        return st.peek();
    }
}