//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public void tester(int i, int j, char [][]grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0') return;
        grid[i][j] = '0';
        tester(i+1,j,grid);
        tester(i+1,j+1,grid);
        tester(i,j+1,grid);
        tester(i-1,j,grid);
        tester(i-1,j-1,grid);
        tester(i,j-1,grid);
        tester(i+1,j-1,grid);
        tester(i-1,j+1,grid);
        return;
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1') { 
                    count++;
                    tester(i,j,grid);
                }
            }
        }
        return count;
    }
}