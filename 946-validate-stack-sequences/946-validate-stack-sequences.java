class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int pushedPtr = 0;
        int poppedPtr = 0;
        
        while(pushedPtr < pushed.length && poppedPtr < popped.length) {
            if(st.empty() || (st.peek() != popped[poppedPtr])) {
                st.push(pushed[pushedPtr]);
                pushedPtr++;
            } else {
                st.pop();
                poppedPtr++;
            }
        }
        
        while(poppedPtr < popped.length && !st.empty() && st.peek() == popped[poppedPtr]) {
            st.pop();
            poppedPtr++;
        }
        
        return (poppedPtr == popped.length);
    }
}