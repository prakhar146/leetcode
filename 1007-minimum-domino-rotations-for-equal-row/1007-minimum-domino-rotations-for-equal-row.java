class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> freqMapTop = new HashMap<>();
        Map<Integer, Integer> freqMapBottom = new HashMap<>();
        Map<Integer, List<Integer>> freqMapTotal = new HashMap<>();
        int maxFrequency = 0;
        
        for(int i: tops) {
            if(!freqMapTop.containsKey(i)) {
                freqMapTop.put(i, 1);
            } else {
                freqMapTop.put(i, freqMapTop.get(i) + 1);
            }
        }
        // printMap(freqMapTop);
        
        for(int i: bottoms) {
            if(!freqMapBottom.containsKey(i)) {
                freqMapBottom.put(i, 1);
            } else {
                freqMapBottom.put(i, freqMapBottom.get(i) + 1);
            }
        }
        // printMap(freqMapBottom);
        
        // System.out.println("------------------------");
        
        for(Integer i: freqMapTop.keySet()) {
            int iFreq = freqMapTop.get(i);
            if(freqMapBottom.containsKey(i)) {
                iFreq += freqMapBottom.get(i);
            }
            maxFrequency = Math.max(maxFrequency, iFreq);
            // System.out.println(i + " freq -> " + iFreq);
            if(!freqMapTotal.containsKey(iFreq)) {
                freqMapTotal.put(iFreq, new ArrayList<>()); 
            }
            List<Integer> l = freqMapTotal.get(iFreq);
            l.add(i);
        }
        
        for(Integer i: freqMapBottom.keySet()) {
            if(!freqMapTop.containsKey(i)) {
                int iFreq = freqMapBottom.get(i);
                maxFrequency = Math.max(maxFrequency, iFreq);
                // System.out.println(i + " freq -> " + iFreq);
                if(!freqMapTotal.containsKey(iFreq)) {
                    freqMapTotal.put(iFreq, new ArrayList<>()); 
                }
                List<Integer> l = freqMapTotal.get(iFreq);
                l.add(i);
            }
        }
        
        // System.out.println("FMAP!");
        // printMap(freqMapTotal);
        
        // for(Integer i: )
        
        if(maxFrequency < tops.length) {
            return -1;
        }
        
        int minAns = Integer.MAX_VALUE;
        
        // System.out.println("----------------------");
        
        for(Integer i: freqMapTotal.keySet()) {
            List<Integer> nums = freqMapTotal.get(i);
            // System.out.println(i + " -> " + Arrays.toString(nums.toArray()));
            if(i < tops.length) {
                continue;
            }
            for(Integer num: nums) {
                int currentAns = 0;
            if(freqMapTop.containsKey(num) && (!freqMapBottom.containsKey(num) || (freqMapBottom.get(num) < freqMapTop.get(num)))) {
                for(int j = 0; j < tops.length; j++) {
                    if(tops[j] != num) {
                        if(bottoms[j] == num) {
                            currentAns++;
                        } else {
                            currentAns = -1;
                            break;
                        }
                    }
                }
                if(currentAns > -1) {
                    minAns = Math.min(minAns, currentAns);
                }
            } else {
                for(int j = 0; j < bottoms.length; j++) {
                    if(bottoms[j] != num) {
                        if(tops[j] == num) {
                            currentAns++;
                        } else {
                            currentAns = -1;
                            break;
                        }
                    }
                }
                if(currentAns > -1) {
                    minAns = Math.min(minAns, currentAns);
                }
            }   
            }
        }
        
        if(minAns == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minAns;
        
    }
    
    void printMap(Map<Integer, Integer> m) {
        System.out.println("---------------------------");
        for(Integer i: m.keySet()) {
            System.out.println(i + " --> " + m.get(i));
        }
    }
}