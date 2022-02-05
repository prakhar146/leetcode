class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        List<Integer> anagramIdx = new ArrayList<>();

        int[] cntArray = getCntArray(pArray);
        int[] tmpCntArray = new int[26];
        System.arraycopy(cntArray, 0, tmpCntArray, 0, cntArray.length);
        int wrdCnt = 0;

        // System.out.println(Arrays.toString(tmpCntArray));
        for(int i = 0; i < sArray.length; i++) {
            if(tmpCntArray[(int)sArray[i] - 97] > 0) {
                tmpCntArray[(int)sArray[i] - 97]--;
                wrdCnt++;
            } else {
                i = i - wrdCnt;
                wrdCnt = 0;
                System.arraycopy(cntArray, 0, tmpCntArray, 0, cntArray.length);
            }
            if(wrdCnt == pArray.length) {
                anagramIdx.add(i - (wrdCnt - 1));
                i = i - (wrdCnt - 1);
                wrdCnt = 0;
                System.arraycopy(cntArray, 0, tmpCntArray, 0, cntArray.length);
            }
        }

        return anagramIdx;
    }
    
    int[] getCntArray(char[] pArray) {
        int[] cntArray = new int[26];
        for(char c: pArray) {
            cntArray[((int) c - 97)]++;
        }
        return cntArray;
    }
}