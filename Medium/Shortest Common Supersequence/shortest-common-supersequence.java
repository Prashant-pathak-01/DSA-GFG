//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int longestCommonSubsequence(String x, String y, int m, int n, int i, int j,int [][]dp){
        if(i==m || j==n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res = 0;
        if(x.charAt(i)==y.charAt(j)){
            res = 1+longestCommonSubsequence(x,y,m,n,i+1,j+1,dp);
        } else{
            res = Math.max(longestCommonSubsequence(x,y,m,n,i,j+1,dp),longestCommonSubsequence(x,y,m,n,i+1,j,dp));
        }
        return dp[i][j] = res;
    }
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        int res = longestCommonSubsequence(X,Y,m,n,0,0,dp);
        return m+n-res;
    }
}