class Solution {
    public int brokenCalc(int startValue, int target) {
        int cnt = 0;
        while(target > startValue) {
            if(target % 2 == 1){
                target++;
            } else {
                target /= 2;
            }
            cnt++;
        }
        
        return cnt + (startValue - target);
    }
}