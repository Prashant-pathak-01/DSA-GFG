//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String S) {
        int dp[] = new int[S.length()+1];
        int seen[] = new int[26];
        Arrays.fill(seen,-1);
        dp[0]  =1;
        int mod = 1000000007;
        for(int i=0; i<S.length(); i++){
            int ch = S.charAt(i)-'a';
            dp[i+1] = dp[i]*2%mod;
            if(seen[ch]>=0){
                dp[i+1]-=dp[seen[ch]];
            }
            dp[i+1]%=mod;

            seen[ch] = i;
        }
        if(dp[S.length()]<0) dp[S.length()]+=mod;
        return dp[S.length()];
    }
}