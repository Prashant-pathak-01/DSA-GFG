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
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int res[] = new int[mat.length*mat[0].length];
        int r =0 ;
        int c  = 0;
        int indx =  0;
        for(int i=0; r<mat.length && c<mat[0].length ; i++){
            if(i%2==0){
                while(r>=0 && c<mat[0].length){
                    res[indx++] = mat[r][c];
                    r--;
                    c++;
                }
                if(c==mat[0].length){
                    c--;
                    r+=2;
                }else{
                    r++;
                }
            }else{
                while(c>=0 && r<mat.length){
                    res[indx++] = mat[r][c];
                    r++;
                    c--;
                }
                if(r==mat.length){
                    c+=2;
                    r--;
                }else{
                    c++;
                }
            }
        }
        return res;
    }
}