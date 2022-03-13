class Solution {
    public boolean isValid(String s) {
        // int v1 =  '(' - ')';
        // int v2 =  '{' - '}';
        // int v3 =  '[' - ']';
        
        Map<Character, Character> bracket = new HashMap<>();
        bracket.put('(', ')');
        bracket.put('{', '}');
        bracket.put('[', ']');
        
        Stack<Character> stack = new Stack<>();
        
        int ptr = 0;
        while(ptr < s.length()) {
            char c = s.charAt(ptr);
            Character sTop = null;
            if(!stack.empty()) {
                sTop = stack.peek();
            }
            if(sTop != null && bracket.containsKey(sTop) && bracket.get(sTop) == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
            ptr++;
        }
        
        // System.out.println(v1 + " " + v2 + " " + v3);
        return stack.empty();
    }
}