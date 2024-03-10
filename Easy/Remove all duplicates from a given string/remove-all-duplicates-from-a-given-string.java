//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) map.put(str.charAt(i),i);
        for(int i=0; i<str.length(); i++){
            if(map.get(str.charAt(i))==i) res.append(str.charAt(i));
        }
        return res.toString();
        
    }
}

