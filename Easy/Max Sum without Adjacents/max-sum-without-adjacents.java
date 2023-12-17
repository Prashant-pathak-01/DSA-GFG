//{ Driver Code Starts
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

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxsum(int a[], int n,int i,int []dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = a[i]+maxsum(a,n,i+2,dp);
        int nottake = maxsum(a,n,i+1,dp);
        return dp[i] = Math.max(take,nottake);
        
    }
    int findMaxSum(int arr[], int n) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return maxsum(arr,n,0,dp);
    }
}