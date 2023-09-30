//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        int row = 0;
        int col = 0;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]==1){
                col = 1;
                break;
            }
        }
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i]==1) {
                row = 1;
                break;
            }
                
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    matrix[0][j] = 1;
                    matrix[i][0] = 1;
                }
            }
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[0][j]==1 || matrix[i][0]==1){
                    matrix[i][j] = 1;
                }
            }
        }
        if(col==1){
            for(int i=0; i<matrix.length; i++){
            matrix[i][0] = 1;
        }
        }
        if(row==1){
            for(int i=0; i<matrix[0].length; i++){
            matrix[0][i] = 1;
        }
        }
    }
}