class Solution {
    public int titleToNumber(String columnTitle) {
        int coeff = 1;
        int titleNum = 0;
        int currValue = 0;
        for(int i = (columnTitle.length() - 1); i > -1; i--) {
            currValue = valueOf(columnTitle.charAt(i)) * coeff;
            titleNum += currValue;
            coeff *= 26;
        }
        
        return titleNum;
    }
    
    int valueOf(char c) {
        return ((int) c) - ((int) 'A' - 1);
    }
}

/*

AA -> 26*(valueOf(A)) + valueOf(A)

BA -> 26*(valueOf(B)) + valueOf(A)
    -> 52 + 1 = 43
    
    


*/