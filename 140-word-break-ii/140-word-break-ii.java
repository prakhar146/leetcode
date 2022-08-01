class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        loadDict(dict, wordDict);
        int N = s.length();
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                String tmp = s.substring(i, j + 1);
                if(dict.contains(tmp)) {
                    dp[i][j] = 1;
                }
            }
        }
        char[] arr = s.toCharArray();
        // System.out.println(Arrays.toString(arr));
        // System.out.println("------------------------------");
        // printMatrix(dp);
        
        List<String> words = new ArrayList<>();
        fillWords(dp, 0, words, new StringBuilder(), s);
        return words;
    }
    
    void fillWords(int[][] dp, int row, List<String> words, StringBuilder currentWord, String s) {
        if(row == dp.length) {
            words.add(currentWord.toString());
            return;
        }
        int N = dp[0].length;
        for(int i = 0; i < N; i++) {
            if(dp[row][i] == 1) {
                StringBuilder tmp = new StringBuilder(currentWord);
                if(currentWord.length() == 0) {
                    currentWord.append(s.substring(row, i + 1));
                } else {
                    currentWord.append(" ");
                    currentWord.append(s.substring(row, i + 1));
                }
                fillWords(dp, i + 1, words, currentWord, s);
                currentWord = tmp;
            }
        }
    }
    
    void loadDict(Set<String> dict, List<String> wordDict) {
        for(String s: wordDict) {
            dict.add(s);
        }
    }
    
    void printMatrix(int[][] dp) {
        for(int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }
    }
}