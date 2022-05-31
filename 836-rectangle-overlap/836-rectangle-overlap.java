class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean isLeft = rec2[0] >= rec1[2];
        boolean isBottom = rec2[1] >= rec1[3];
        boolean isRight = rec1[0] >= rec2[2];
        boolean isTop = rec1[1] >= rec2[3];
        
        return !(isLeft || isRight || isTop || isBottom);
    }
}