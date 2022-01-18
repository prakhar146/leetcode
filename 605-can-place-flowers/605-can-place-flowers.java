class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if(n == 0) {
                return true;
            }
            if(canPlace(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        
        return n <= 0;
    }
    
    boolean canPlace(int[] flowerbed, int pos) {
        boolean hasFlowerBedOnLeft = (pos > 0 && flowerbed[pos - 1] > 0);
        boolean hasFlowerBedOnRight = ((pos < flowerbed.length - 1) && flowerbed[pos + 1] > 0);
        if(hasFlowerBedOnLeft || hasFlowerBedOnRight || flowerbed[pos] > 0) {
            return false;
        }
        return true;
    }
}