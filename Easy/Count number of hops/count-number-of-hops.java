//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static long mod = 1000000007;
    static long counter(int n, int sum,long[] dp){
        if(sum==n){
            return 1;
        } 
        if(sum>n) return 0;
        if(dp[sum]!=-1) return dp[sum];
        long takeOne = counter(n,sum+1,dp)%mod;
        long takeTwo = counter(n,sum+2,dp)%mod;
        long takeThree = counter(n,sum+3,dp)%mod;
        long temp = (takeOne+takeTwo+takeThree)%mod;
        dp[sum] = temp;
        return temp;
    }
    static long countWays(int n)
    {
        long dp[] = new long[n+1];
        Arrays.fill(dp,-1);
        return counter(n,0,dp);
    }
    
}

