class BrowserHistory {
    Map<String, Integer> urlToIdx;
    int currentUrlPtr;
    List<String> history;
    public BrowserHistory(String homepage) {
        urlToIdx = new HashMap<>();
        currentUrlPtr = 0;
        history = new ArrayList<>();
        
        addUrlToHistory(homepage);
    }
    
    public void visit(String url) {
        // if(urlToIdx.containsKey(url)) {
        //     int urlIdx = urlToIdx.get(url);
        //     currentUrlPtr = urlIdx;
        //     flushHistoryFrom(currentUrlPtr + 1);
        // } else {
        //     addUrlToHistory(url);
        //     currentUrlPtr = urlToIdx.get(url);
        // }
        flushHistoryFrom(currentUrlPtr + 1);
        addUrlToHistory(url);
        currentUrlPtr = urlToIdx.get(url);
    }
    
    public String back(int steps) {
        int validUrlIdx = Math.max(currentUrlPtr - steps, 0);
        currentUrlPtr = validUrlIdx;
        // System.out.println("back -> " + validUrlIdx);
        return history.get(validUrlIdx);
    }
    
    public String forward(int steps) {
        int validUrlIdx = Math.min(currentUrlPtr + steps, history.size() - 1);
        currentUrlPtr = validUrlIdx;
        return history.get(validUrlIdx);
    }
    
    private void addUrlToHistory(String url) {
        history.add(url);
        urlToIdx.put(url, history.size() - 1);
        // System.out.println("history " + history);
    }
    
    private void flushHistoryFrom(int idx) {
        for(int i = idx; i < history.size(); i++) {
            urlToIdx.remove(history.get(i));
        }
        history = history.subList(0, idx);
        currentUrlPtr = history.size() - 1;
    }
        
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

/*
list of strings

1. arrayList --> O(k) for (back, forward), visit --> O(n)





*/