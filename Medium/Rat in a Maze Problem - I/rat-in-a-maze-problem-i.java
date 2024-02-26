//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static void generate(ArrayList<String> res, String str, int m[][], int n, int i, int j){
        if(i>=n || j>=n || i<0 || j<0 || m[i][j]==0) return;
        if(i==n-1 && j==n-1) {
            res.add(str);
            return;
        }
        m[i][j] = 0;
        generate(res,str+'D',m,n,i+1,j);
        generate(res,str+'U',m,n,i-1,j);
        generate(res,str+'L',m,n,i,j-1);
        generate(res,str+'R',m,n,i,j+1);
        m[i][j] = 1;
        return;
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        generate(res,"",m,n,0,0);
        return res;
    }
}