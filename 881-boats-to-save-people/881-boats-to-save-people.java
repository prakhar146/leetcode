class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int cnt = 0;
        while(l <= r) {
            int totalWeight = people[l] + people[r];
            if(totalWeight <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            cnt++;
        }
        
        return cnt;
    }
}