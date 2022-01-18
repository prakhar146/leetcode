class Solution {
    public int maxDistToClosest(int[] seats) {
        int distance = seats.length;
        int maxDistance = -1;
        int[] distanceFromLeftAndRight = new int[seats.length];
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                distance = 0;
            } else {
                distance++;
            }
            distanceFromLeftAndRight[i] = distance;
        } 
        distance = seats.length;
        for(int i = seats.length - 1; i > -1; i--) {
            if(seats[i] == 1) {
                distance = 0;
            } else {
                distance++;
            }
            distanceFromLeftAndRight[i] = Math.min(distanceFromLeftAndRight[i], distance);
            maxDistance = Math.max(maxDistance, distanceFromLeftAndRight[i]);
        }
        
        return maxDistance;
    }
}