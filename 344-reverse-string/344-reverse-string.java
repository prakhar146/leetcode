class Solution {
    public void reverseString(char[] s) {
        int mid = (int) Math.ceil(s.length / 2);
        for(int i = 0; i < mid; i++) {
            char c1 = s[i];
            char c2 = s[s.length - i - 1];
            s[i] = c2;
            s[s.length - i - 1] = c1;
        }
        return;
    }
}

/*
hello -> 5
5 / 2 = 2
3

0, 

0, 4
1, 3
2, 2
 
hellos -> 6
6 / 2 = 3

0, 5
1, 4
2, 3
3, 2

*/