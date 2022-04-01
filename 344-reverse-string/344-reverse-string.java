class Solution {
    public void reverseString(char[] s) {
        int mid = (int) Math.ceil(s.length / 2);
        char temp = 'p';
        for(int i = 0; i < mid; i++) {
            temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
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