// { Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().maxProduct(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int maxProduct(int arr[], int n) {
	    int m1 = 0; int m2 = 0;
	    int M1 = 0; int M2 = 0;
	    
	    for(int i: arr) {
	        if(i > M1) {
	            M2 = M1;
	            M1 = i; 
	        } else {
	            M2 = Math.max(i, M2);
	        }
	        if(i < m1) {
	                m2 = m1;
	                m1 = i;
            } else {
                m2 = Math.min(m2, i);
            }
	    }
	    
	    int prodMax = M1 * M2;
	    int prodMin = m1 * m2;
	    
	    return Math.max(prodMax, prodMin);
    }
}