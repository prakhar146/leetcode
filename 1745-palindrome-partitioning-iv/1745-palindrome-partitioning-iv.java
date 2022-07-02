class Solution {
    String testString;
    List<String> palindromes = new ArrayList<>();
    public boolean checkPartitioning(String s) {
        int size = s.length();
        System.out.println(size);
        testString = s;
        boolean[][] isPalindrome = new boolean[size][size];
        prepareIsPalindrom(s, isPalindrome);
        // printArray(isPalindrome);
        // System.out.println(isPalindrome[0][22]);
        // System.out.println(isPalindrome[23][24]);
        // System.out.println(isPalindrome[25][33]);
        // isPalindrome[0][22] = true; 
        // isPalindrome[25][33] = true;
        boolean ans = canPartition(0, isPalindrome, size, 2);
        return ans;
    }
    
    boolean canPartition(int p, boolean[][] isPalindrome, int n, int noOfPartitions) {
        if(noOfPartitions == 0) {
            if(p < n && isPalindrome[p][n - 1]) {
                if(p < n) {
                    palindromes.add(testString.substring(p));
                }
                System.out.println(Arrays.toString(palindromes.toArray()));
                if(p < n) {
                    palindromes.remove(palindromes.size() - 1);
                }
                return true;
            }
            else return false;
        }
        boolean ans = false;
        for(int j = p; j < n; j++) {
            if(isPalindrome[p][j]) {
                palindromes.add(testString.substring(p, j + 1));
                boolean can = canPartition(j + 1, isPalindrome, n, noOfPartitions - 1);
                palindromes.remove(palindromes.size() - 1);
                ans = ans || can;
            }
        }
        return ans;
    }
    
    void prepareIsPalindrom(String s, boolean[][] isPalindrome) {
        int l = 0, r = 0;
        int size = s.length();
        int mid = size / 2;
        if(size % 2 == 0) {
            l = mid - 1;
            r = mid;
        } else {
            l = r = mid;
        }
        
        for(int gap = 0; gap < size; gap++) {
            int i = 0;  
            for(int j = (i + gap); j < size; j++, i++) {
                if(gap == 0) {
                    isPalindrome[i][j] = true;
                } else {
                    char leftChar = s.charAt(i);
                    char rightChar = s.charAt(j);
                    if(leftChar == rightChar) {
                        if(gap == 1) {
                            isPalindrome[i][j] = true;
                        } else {
                            isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                        }
                    }
                }
            }
        }
    }
    
    void printArray(boolean[][] isPalindrome) {
        for(boolean[] row: isPalindrome) {
            System.out.println(Arrays.toString(row));
        }
    }
}
/*
    j ->
        a   b   c   b   d   d
i       0   1   2   3   4   5

    a   1   0   0   0   0   0   

    b   0   1   0   1   0   0

    c   0   0   1   0   0   0

    b   0   0   0   1   0   0

    d   0   0   0   0   1   1

    d   0   0   0   0   0   1

----------------------------

while(i < n) {
    for(int j = i; j < n; j++) {
        if(isPalindrome[i][j] == 1) {
            stack.push(new Pair(i,j));
        }
    }
   
   Pair p = stack.pop();
   i = p.j + 1;
}

stack - > (1,1), (1,3)

-----------------------------

canPartition(p, q, isPalindrome[][], noOfPartition) {
    if(noOfPartitions == 0) {
        if(isPalindrome[i][n - 1] = 1)) return true;
        else return false;
    }
    boolean ans = false;
    for(int i = p; i < n; i++) {
        for(int j = q; j < n; j++) {
            if(isPalindrom[i][j] == 1) {
                ans = ans || canPartition(j + 1, noOfPartition - 1);
            }
        }
    }
    return ans;
}
-----------------------------
for(int gap = 0; gap < n; gap++) {
    int i = 0;  
    for(int j = (i + gap); j < n; j++;i++) {
        if(gap == 0) {
            isPalindrome[i][j] = true;
        } else {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);
            if(leftChar == rightChar) {
                if(gap == 1) {
                    isPalindrome[i][j] = true;
                } else {
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                }
            }
        }
        
    }
}

------------------------------

canPartition(0, 2)
    canPalindrom(1, 1)
        canPalindrom(2, 0)
    canPalindrome(4, 0)
    

*/