class FreqStack {

    int maxFrequency;
    Map<Integer, Stack<Integer>> smap;
    Map<Integer, Integer> fmap;
    
    public FreqStack() {
        maxFrequency = 0 ;
        smap = new HashMap<>();
        fmap = new HashMap<>();
        
    }
    
    private void pushToStack(int val, int freq) {
        maxFrequency = Math.max(maxFrequency, freq);
        if(smap.isEmpty() || !smap.containsKey(freq)) {
            smap.put(freq, new Stack<Integer>());
        } 
        Stack st = smap.get(freq);
        st.push(val);
    }
    
    public void push(int val) {
        if(fmap.isEmpty() || !fmap.containsKey(val)) {
            fmap.put(val, 0);
        }
        int newFreq = fmap.get(val) + 1;
        fmap.put(val, newFreq);
        pushToStack(val, newFreq);
    }
    
    private int popFromStack() {
        int maxFNum = smap.get(maxFrequency).pop();
        if(smap.get(maxFrequency).empty()) {
            smap.remove(maxFrequency);
            maxFrequency--;
        }
        return maxFNum;
    }
    
    public int pop() {
        int val = popFromStack();
        int newFreq = fmap.get(val) - 1;
        fmap.put(val, newFreq);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */