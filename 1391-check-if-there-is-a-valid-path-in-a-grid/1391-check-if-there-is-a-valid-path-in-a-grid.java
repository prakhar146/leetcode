class Solution {
    Map<Integer, List<Integer[]>> streetToValidMovements = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
    public boolean hasValidPath(int[][] grid) {
        initialiseStreetToValidMoves();
        return checkForValidPath(grid, 0, 0);
        
    }
    
    boolean checkForValidPath(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (y >= grid.length || x >= (grid[0].length)) {
            return false;
        }
        if (y == (grid.length - 1) && x == (grid[0].length - 1)) {
            return true;
        }
        int currentStreet = grid[y][x];
        String currentPos = String.valueOf(y).concat(", ").concat(String.valueOf(x));
        visited.put(currentPos, true);
        List<Integer[]> validMovements = streetToValidMovements.get(currentStreet);
        boolean isValid = false;
        for (Integer[] move: validMovements) {
            int nextY = y + move[1];
            int nextX = x + move[0];
            try
            {
                int nextStreet = grid[nextY][nextX];
                String nextPosString = String.valueOf(nextY).concat(", ").concat(String.valueOf(nextX));
                boolean isValidMove = !visited.containsKey(nextPosString) && canMove(move, nextStreet) && checkForValidPath(grid, nextX, nextY);
                isValid = isValid || isValidMove;
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }

        return isValid;
    }
    
    
    
    boolean canMove(Integer[] movement, int streetNumber) {
        List<Integer[]> validMovements = streetToValidMovements.get(streetNumber);
        for (Integer[] validMovement: validMovements) {
            int balanceX = validMovement[0] + movement[0];
            int balanceY = validMovement[1] + movement[1];
            if (balanceX == 0 && balanceY == 0) {
                return true;
            }
        }

        return false;
    }
    
    void initialiseStreetToValidMoves() {
        List<Integer[]> validMoves = new ArrayList<>();

        validMoves.add(new Integer[] {-1, 0});
        validMoves.add(new Integer[] {1, 0});
        streetToValidMovements.put(1, validMoves);

        validMoves = new ArrayList<>();
        validMoves.add(new Integer[] {0, -1});
        validMoves.add(new Integer[] {0, 1});
        streetToValidMovements.put(2, validMoves);

        validMoves = new ArrayList<>();
        validMoves.add(new Integer[] {-1, 0});
        validMoves.add(new Integer[] {0, 1});
        streetToValidMovements.put(3, validMoves);

        validMoves = new ArrayList<>();
        validMoves.add(new Integer[] {1, 0});
        validMoves.add(new Integer[] {0, 1});
        streetToValidMovements.put(4, validMoves);

        validMoves = new ArrayList<>();
        validMoves.add(new Integer[] {-1, 0});
        validMoves.add(new Integer[] {0, -1});
        streetToValidMovements.put(5, validMoves);

        validMoves = new ArrayList<>();
        validMoves.add(new Integer[] {1, 0});
        validMoves.add(new Integer[] {0, -1});
        streetToValidMovements.put(6, validMoves);

    }
}