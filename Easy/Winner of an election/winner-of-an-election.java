//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    // Function to return the name of the candidate that received maximum votes.
    public static String[] winner(String arr[], int n) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        String res[] = new String[2];
        res[1] = "0";

        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) > Integer.parseInt(res[1]) || (map.get(arr[i]) == Integer.parseInt(res[1]) && arr[i].compareTo(res[0]) < 0)) {
                res[1] = String.valueOf(map.get(arr[i]));
                res[0] = arr[i];
            }
        }

        return res;
    }
}