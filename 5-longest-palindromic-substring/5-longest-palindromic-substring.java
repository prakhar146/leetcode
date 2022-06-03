class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] isPalindrome = new int[n][n];
        String maxString =  "";
        for(int g = 0; g < n; g++) {
            for(int i = 0, j = g; (i < n && j < n); i++, j++) {
                if(g == 0) {
                    isPalindrome[i][j] = 1;
                } else if(g == 1) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j) ? 1 : 0);
                } else {
                    isPalindrome[i][j] = ((s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1] == 1)) ? 1 : 0;
                }
                if((isPalindrome[i][j] == 1) && ((j - i) + 1) > maxString.length()) {
                    maxString = s.substring(i, j + 1); 
                }
            }
        }
        
        // System.out.println(maxString);
//         for(int g = (n - 1); g > -1; g--) {
//             for(int i 0, j = g; (i < n && j < n); i++, j++) {
                
//             }
//         }
        
        // printMatrix(isPalindrome);
        return maxString;
    }
    
    private void printMatrix(int[][] matrix) {
        for(int[] nums: matrix) {
            System.out.println(Arrays.toString(nums));
        }
    }
                                          
                                          
}