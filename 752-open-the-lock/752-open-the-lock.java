class Solution {
    enum WheelAction {
        TURN_RIGHT,
        TURN_LEFT
    }
    int[] wheel = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    public int openLock(String[] deadends, String target) {
        String startPosition = "0000";
        Queue<String> nodesToVisit = new LinkedList<>();
        nodesToVisit.offer(startPosition);
        Map<String, Boolean> deadEnds = new HashMap<>();
        Map<String, Boolean> visitedNodes = new HashMap<>();
        for (String deadend : deadends) {
            deadEnds.put(deadend, true);
        }
        int level = 0;
        visitedNodes.put(startPosition, true);

        while (!nodesToVisit.isEmpty()) {
            int size = nodesToVisit.size();
            while (size > 0) {
                StringBuilder currentPosition = new StringBuilder(nodesToVisit.poll());
//                System.out.println("CURRENT -> " + currentPosition);

//                System.out.println("MAP SIZE -> " + visitedNodes.size());
                if (deadEnds.containsKey(currentPosition.toString())) {
                    size--;
                    continue;
                }
                if (currentPosition.toString().equals(target)) {
                    return level;
                }

                for (int i = 0 ; i < 4; i++) {
                    int currentWheelPosition = (int) currentPosition.charAt(i);
                    // TURN RIGHT
                    String nextPosition = turnWheel(currentPosition.toString(), i, WheelAction.TURN_RIGHT);

                    if (!deadEnds.containsKey(nextPosition) && !visitedNodes.containsKey(nextPosition)) {
                        visitedNodes.put(nextPosition, true);
                        nodesToVisit.offer(nextPosition);
                    }

//                    if (visitedNodes.containsKey(nextPosition) && visitedNodes.size() == 2956) {
//                        System.out.println("HERE");
//                    }

                    // TURN LEFT
                    nextPosition = turnWheel(currentPosition.toString(), i, WheelAction.TURN_LEFT);

                    if (!deadEnds.containsKey(nextPosition) && !visitedNodes.containsKey(nextPosition)) {
                        visitedNodes.put(nextPosition, true);
                        nodesToVisit.offer(nextPosition);
                    }
                }
                size--;
            }
            level++;
        }

        return -1;
    }
    
    String turnWheel(String currentPos, int wheelNumber, WheelAction wa) {
        int wheelPos = (int) currentPos.charAt(wheelNumber) - 48;
        int nextPos = -1;
        switch (wa) {
            case TURN_LEFT:
                nextPos = (wheel.length + (wheelPos - 1)) % wheel.length;
                break;
            case TURN_RIGHT:
                nextPos = (wheel.length + (wheelPos + 1)) % wheel.length;
                break;
        }

        return wheelNumber != 3 ?
                currentPos.substring(0, wheelNumber) + (char) (nextPos + 48) + currentPos.substring(wheelNumber + 1) :
                currentPos.substring(0, wheelNumber) + (char) (nextPos + 48);
    }
}

/*
["8887","8889","8878","8898","8788","8988","7888","9888"]
"8888"
*/