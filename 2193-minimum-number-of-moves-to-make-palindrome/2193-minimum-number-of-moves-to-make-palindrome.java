class Solution {
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        char[] cArr = s.toCharArray();
        int cnt = 0;
        
        while(left < right) {
            if(cArr[left] == cArr[right]) {
                left++;
                right--;
                continue;
            }
            
            int rightPtr = right;
            while(cArr[rightPtr] != cArr[left]) {
                rightPtr--;
            }
            
            if(rightPtr == left) {
                cnt++;
                swap(cArr, left, left + 1);
            } else {
                while(rightPtr < right) {
                    // System.out.println(cArr);
                    cnt++;
                    swap(cArr, rightPtr, rightPtr + 1);
                    rightPtr++;
                }
            }
        }
        return cnt;
    }
    
    void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}