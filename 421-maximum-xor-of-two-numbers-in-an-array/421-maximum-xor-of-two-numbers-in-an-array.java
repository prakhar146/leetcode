class Solution {
    
    class Trie {
        
        
        private TrieNode root;
        
        Trie() {
            this.root = new TrieNode(-1);
        }
        
        public void insert(int num) {
            int nob = 30;
            TrieNode root = this.root;
            int mask = 1;
            
            while(nob >= 0) {
                mask = 1 << nob;
                int bit = (num & mask) >> nob;
                
                if(root.children[bit] == null) {
                    root.children[bit] = new TrieNode(bit);
                }
                
                root = root.children[bit];
                nob--;
            }
            
            root.isNumber = true;
        }
        
        public int query(int num) {
            int nob = 30;
            TrieNode root = this.root;
            int mask = 1;
            int ans = 0;
            
            while(nob >= 0) {
                mask = 1 << nob;
                int bit = (num & mask) >> nob;   
                
                if(root.children[bit] == null) {
                    ans |= ((bit ^ 1) << nob);
                    root = root.children[(bit ^ 1)];
                } else {
                    ans |= (bit << nob);
                    root = root.children[bit];
                }
                
                
                nob--;
            }
            
            // System.out.println("queried for -> " + num + " \nfound -> " + ans);
            
            return ans;
        }
        
        public void printTrie() {
            printTrieRec(this.root, new ArrayList<Integer>());
        }
        
        private void printTrieRec(TrieNode root, List<Integer> l) {
            if(root == null) {
                return;
            }
            l.add(root.value);
            if(root.isNumber) {
                System.out.println(Arrays.toString(l.stream().mapToInt(it -> it).toArray()));
            }
            printTrieRec(root.children[0], l);
            printTrieRec(root.children[1], l);
            l.remove(l.size() -1);
        }
        
        
        class TrieNode {
            int value;
            boolean isNumber;
            TrieNode[] children;
            
            TrieNode(int v) {
                value = v;
                isNumber = false;
                children = new TrieNode[2];
            }
        }
    }
    
    
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        
        for(int num: nums) {
            t.insert(num);
        }
        
        // t.printTrie();
        
        // System.out.println();
        
        
        int max = 0;
        for(int num: nums) {
            int bestNum = (Integer.MAX_VALUE ^ num);
            int numFound = t.query(bestNum);
            max = Math.max(max, (num ^ numFound));
        }
        
        return max;
    }
}