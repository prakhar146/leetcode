class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        reverseArray(piles);
        // System.out.println("piles " + Arrays.toString(piles));
        int bobCnt = piles.length / 3;
        int myCnt = 0;
        
        for(int i = 1; i < (piles.length - bobCnt); i += 2) {
            myCnt += piles[i];
        }
        
        return myCnt;
    }
    
    void reverseArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < (n / 2); i++) {
            int tmp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;
        }
    }
}

/*

[2,4,1,2,7,8]

--[2,4,1]--
Alice - 4
Me - 2
Bob - 1

--[2,7,8]--
Alice - 8
Me - 7
Bob - 2

------------------

Alice -> 4 + 8 = 12
Me -> 2 + 7 = 9
Bob -> 1 + 2 = 3


---------IDEA----------

[2,4,1,2,7,8]
-> sort desc
[8,7,4,2,2,1]

[8,7,1]
Alice - 8
Me - 7

[4,2,2]
Alice - 4
Me - 2

-----------------------
*/