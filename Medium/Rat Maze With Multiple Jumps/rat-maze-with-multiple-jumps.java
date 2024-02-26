//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public boolean generate(int arr[][],int res[][], int i, int j){
        if(i>=arr.length || j>=arr[0].length || i<0 || j<0 || res[i][j]==1) return false;
        res[i][j] = 1;
        if(i==arr.length-1 && j==arr[0].length-1 ) {
            return true;
        }
        for(int x=1; x<=arr[i][j]; x++){
            boolean a  = generate(arr,res,i,j+x);
            if(a) return true;
            a = generate(arr,res,i+x,j);
            if(a) return true;
        }
        res[i][j] = 0;
        return false;
    }
    public int[][] ShortestDistance(int[][] matrix)
    {
        int res[][] = new int[matrix.length][matrix[0].length];
        boolean result = generate(matrix,res,0,0);
        if(result) return res;
        int def[][] = new int[1][1];
        def[0][0] = -1;
        return def;
    }
}