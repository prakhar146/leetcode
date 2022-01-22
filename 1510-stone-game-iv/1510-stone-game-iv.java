class Solution {
    public boolean winnerSquareGame(int n) {
        boolean canWin[] = new boolean[n + 1];
        canWin[0] = false;
        canWin[1] = true;

        int num;
        int stonesLeft;
        for (int i = 1; i <= n; i++) {
            num = 1;
            while ((num * num) <= i) {
                stonesLeft = i - (num * num);
                canWin[i] = (canWin[i] || !canWin[stonesLeft]);
                num++;
            }
        }

        return canWin[n];
    }
}