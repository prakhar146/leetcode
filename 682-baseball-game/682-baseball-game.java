class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s = new  Stack<>();
        
        for(int i = 0; i < ops.length; i++) {
            switch(ops[i]) {
                case "+":
                    int top1 = s.pop();
                    int top2 = s.peek();
                    int sum = top1 + top2;
                    s.push(top1);
                    s.push(sum); 
                    break;
                case "D":
                    int top = s.peek();
                    top *= 2;
                    s.push(top);
                    break;
                case "C":
                    s.pop();
                    break;
                default:
                    s.push(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;
        while(!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }
}