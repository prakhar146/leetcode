class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int CON = 1_000_000_007;
        Arrays.sort(arr);
        long ans = 0;
        
        for(int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            
            int j = i + 1;
            int k = arr.length - 1;
            
            while(j < k) {
                int sum1 = arr[j] + arr[k];
                if(sum1 > diff) {
                    k--;
                } else if(sum1 < diff) {
                    j++;
                } else if (arr[j] != arr[k]) {
                    int cnt1 = 1;
                    while((j + 1) < k && arr[j] == arr[j + 1]) {
                        cnt1++;
                        j++;
                    }
                    int cnt2 = 1;
                    while((k - 1) > j && arr[k] == arr[k - 1]) {
                        cnt2++;
                        k--;
                    }
                    
                    ans += cnt1 * cnt2;
                    ans %= CON;
                    j++;
                    k--;
                } else {
                    ans += (k-j+1) * (k-j) / 2;
                    ans %= CON;
                    break;
                }
            }
        }
        return (int) ans;
    }
}