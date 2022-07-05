class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] isPalindrome = new int[n][n];
        int ptr1 = 0;
        int ptr2 = 0;
        int maxGap = -1;
        for(int gap = 0; gap < n; gap++) {
            int i = 0;
            for(int j = (i + gap); j < n; j++, i++) {
                if(gap == 0) {
                    if(gap > maxGap) {
                       ptr1 = i;
                       ptr2 = j + 1;
                       maxGap = gap;
                    }
                    isPalindrome[i][j] = 1;
                } else {
                    char left = s.charAt(i);
                    char right = s.charAt(j);
                    if(gap == 1) {
                            if(left == right) {
                                isPalindrome[i][j] = 1;
                                if(gap > maxGap) {
                                    ptr1 = i;
                                    ptr2 = j + 1;
                                    // System.out.println("ptr1 " + ptr1 + " ptr2 " + ptr2 +" gap " + gap);
                                    maxGap = gap;
                                }
                            }
                    } else {
                        if(left == right) {
                            isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                            // System.out.println("ptr1 " + ptr1 + " ptr2 " + ptr2 +" gap " + gap);
                            if((isPalindrome[i][j] == 1) && (gap > maxGap)) {
                                ptr1 = i;
                                ptr2 = j + 1;
                                // System.out.println("ptr1 " + ptr1 + " ptr2 " + ptr2 +" gap " + gap);
                                maxGap = gap;
                            }
                        }
                    }
                    
                }
            }
        }
        
        
        // for(int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(isPalindrome[i]));
        // }
        
        return s.substring(ptr1, ptr2);
    }
}