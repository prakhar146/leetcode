class Solution {
    Integer[][] minCostByDay = new Integer[366][396];
    public int mincostTickets(int[] days, int[] costs) {
       return getMinCostHelper(days, costs, 0, 0);
    }
    
    int getMinCostHelper(int[] days, int[] costs, int passValidity, int currentPosition) {
        if(currentPosition >= days.length) {
            return 0;
        }
        if(minCostByDay[days[currentPosition]][passValidity] != null) {
            return minCostByDay[days[currentPosition]][passValidity];
        }

        int op1, op2, op3, op4;
        op1 = op2 = op3 = op4 =  costs[2] * days.length;

        if (passValidity >= days[currentPosition]) {
            int minCost = 0;
            minCost = minCostByDay[days[currentPosition-1]] != null && minCostByDay[days[currentPosition-1]][passValidity] != null ? minCostByDay[days[currentPosition-1]][passValidity] : getMinCostHelper(days, costs, passValidity, currentPosition + 1);
            minCostByDay[days[currentPosition]][passValidity] = minCost;
            return minCost;
        } else {
            op1 = costs[0] + getMinCostHelper(days, costs, days[currentPosition], currentPosition + 1);
            op2 = costs[1] + getMinCostHelper(days, costs, days[currentPosition] + 6, currentPosition + 1);
            op3 = costs[2] + getMinCostHelper(days, costs, days[currentPosition] + 29, currentPosition + 1);
        }

        int minCost = Math.min(op1, Math.min(op2, Math.min(op3, op4)));
        minCostByDay[days[currentPosition]][passValidity] = minCost;

        return minCost;
    }
}

/*
[2, 7, 15]


[1, 4, 6, 7, 8, 20]


cost = 2
passValidity = x + 1
lastDay = days[days.length()]

Integer[] minCostByDay = new Integer[366];
getMinCost(days, costs, passValidity, currentPosition) {
    if(passValidity > days[days.length()]) {
        return 0;
    }
    if(minCostByDay[days[currentPosition]] != null) {
        return minCostByDay[days[currentPosition]];
    }
    
    int op1, op2, op3, op4;
    op1 = op2 = op3 = op4 =  costs[2] * days.length();

    if (passValidity > days[currentPosition]) {
        op4 = getMinCost(days, costs, passValidity);
    } else {
        op1 = costs[0] + getMinCost(days, costs, days[currentPosition], currentPosition + 1);
        op2 = costs[1] + getMinCost(days, costs, days[currentPosition] + 6, currentPosition + 1);
        op3 = costs[2] + getMinCost(days, costs, days[currentPosition] + 29, currentPosition + 1);
    }
    
    minCostByDay[days[currentPosition]] = Math.min(op1, Math.min(op2, Math.min(op3, op4)));
    return minCostByDay[days[currentPosition]];
}



ptA ptB ptC ptD

pass 1: ptA ptB

*/