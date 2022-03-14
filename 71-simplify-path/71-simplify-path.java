class Solution {
    public String simplifyPath(String path) {
        Stack<Character> s = new Stack();
        int ptr = 0;
        s.push('/');
        
        int dotCnt = 0;
        int slashCnt = 1;
        
        while(ptr < path.length()) {
            char c = path.charAt(ptr);
            if(c == '/') {
                slashCnt++;
                if(s.peek() == '/') {
                    ptr++;
                    dotCnt = 0;
                    continue;
                } else if (s.peek() == '.') {
                    if(dotCnt == 1) {
                        s.pop();
                    } else if(dotCnt == 2) {
                        popTillParent(s);
                        dotCnt = 0;
                        continue;
                    } else {
                        s.push(c);
                    }
                } else {
                    s.push(c);
                }
                dotCnt = 0;
            } else if (c == '.') {
                s.push(c);
                if(slashCnt > 0 || dotCnt > 0) {
                    dotCnt++;   
                }
                slashCnt = 0;
            } else {
                dotCnt = 0;
                slashCnt = 0;
                s.push(c);
            }
            ptr++;
        }
        
        
        if(s.size() > 1) {
            if(s.peek() == '/') {
                s.pop();
            } else if(s.peek() == '.' && dotCnt == 2) {
                popTillParent(s);
            } else if(s.peek() == '.' && dotCnt == 1) {
                s.pop();
                if(s.peek() == '/' && s.size() > 1) {
                    s.pop();
                }
            }
        }
        
        StringBuilder cPath = new StringBuilder();
        
        while(s.size() > 0) {
            char top = s.pop();
            cPath.append(top);
        }
        
        cPath.reverse();
        
        return cPath.toString();
    }
    
    void popTillParent(Stack<Character> s) {
        int slashCnt = 0;
        while(slashCnt < 2 && s.size() > 1) {
            char c = s.pop();
            if(c == '/') {
                slashCnt++;
            }
        }
    }
}