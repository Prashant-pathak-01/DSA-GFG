//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static boolean func(int N, int []arr, int sum, int i,int [][]dp){
        if(sum==0) return true;
        if(i==N-1) return arr[i]==sum;
        if(dp[i][sum]!=-1) return (dp[i][sum]==1)?true:false;
        boolean take = false;
        if(arr[i]<=sum){
            take = func(N,arr,sum-arr[i],i+1,dp);
        }
        boolean notTake = func(N,arr,sum,i+1,dp);
        boolean res = take || notTake;
        dp[i][sum] = (res==true)?1:0;
        return res;
    }
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i=0; i<N; i++){
            sum+=arr[i];
        }
        if(sum%2==1) return 0;
        sum/=2;
        int dp[][] = new int[N+1][sum+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        
        return func(N,arr,sum,0,dp)?1:0;
    }
}