class Solution {
    Integer[] minArray = new Integer[366];
    public int mincostTickets(int[] days, int[] costs) {
        return minConstDFS(days, costs, 0, 0);
    }
    
    int minConstDFS(int[] days, int[] costs, int passValidity, int currentPosition) {
                if(currentPosition >= days.length) {
            return 0;
        }
        if(minArray[days[currentPosition]] != null) {
            return minArray[days[currentPosition]];
        }

        int op1, op2, op3, op4;
        op1 = op2 = op3 = op4 =  costs[2] * days.length;

        if (passValidity >= days[currentPosition]) {
            op4 = minConstDFS(days, costs, passValidity, currentPosition + 1);
        } else {
            op1 = costs[0] + minConstDFS(days, costs, days[currentPosition], getNextPosition(days, days[currentPosition]));
            op2 = costs[1] + minConstDFS(days, costs, days[currentPosition] + 6, getNextPosition(days, days[currentPosition] + 6));
            op3 = costs[2] + minConstDFS(days, costs, days[currentPosition] + 29, getNextPosition(days, days[currentPosition] + 29));
        }

        int minCost = Math.min(op1, Math.min(op2, Math.min(op3, op4)));
        minArray[days[currentPosition]] = minCost;

        return minCost;
    }
    
    int getNextPosition(int[] days, int passValidity) {
        for(int i = 0 ; i < days.length; i++) {
            if (days[i] > passValidity) {
                return i;
            }
        }
        return days.length;
    }
}