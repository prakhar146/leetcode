class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        loadParenthesis(parenthesis, 0, 0, new StringBuilder(), n);
        return parenthesis;
    }
    
    void loadParenthesis(List<String> parenthesis, int openCnt, int closeCnt, StringBuilder sb, int n) {
        if(sb.length() == (n * 2)) {
            parenthesis.add(sb.toString());
            return;
        }
        if(openCnt > closeCnt) {
            loadParenthesis(parenthesis, openCnt, closeCnt + 1, sb.append(')'), n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(openCnt < n) {
            loadParenthesis(parenthesis, openCnt + 1, closeCnt, sb.append('('), n);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}