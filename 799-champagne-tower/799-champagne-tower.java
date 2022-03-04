class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[102][102];
        glasses[0][0] = (double) poured;
        for(int i = 0; i <= query_row; i++) {
            for(int j = 0; j <= i; j++) {
                double amountToPour = ((glasses[i][j] - 1.0) / 2.0);
                if(amountToPour > 0) {          
                    glasses[i + 1][j] += amountToPour;
                    glasses[i + 1][j + 1] += amountToPour;
                }
            }
        }
        
        return Math.min(1, glasses[query_row][query_glass]);
    }
}