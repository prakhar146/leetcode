class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        double speedPerPile =  (double) ((double)piles.length / (double)h);
        int minSpeed = (int) Math.ceil(speedPerPile * Arrays.stream(piles).min().getAsInt());
        int maxSpeed = Arrays.stream(piles).max().getAsInt();

        int hours;

        int minSpeedReqd = maxSpeed;

        while (minSpeed <= maxSpeed) {
            int midSpeed = (maxSpeed + minSpeed) / 2;
            hours = 0;
            for (int pile: piles) {
                int timeTaken = (int) Math.ceil((double) pile / (double) midSpeed);
                hours += timeTaken;
                if (hours > h) {
                    break;
                }
            }
            if (hours <= h) {
                minSpeedReqd = Math.min(midSpeed, minSpeedReqd);
                maxSpeed = midSpeed - 1;
            } else  {
                minSpeed = midSpeed + 1;
            }
        }

        return minSpeedReqd;
    }
}