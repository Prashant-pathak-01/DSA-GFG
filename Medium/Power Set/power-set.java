//{ Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void generate(List<String> list, String str, String res, int i){
        if(res.length()!=0) list.add(res);
        for(int x=i; x<str.length(); x++){
            generate(list,str,res+str.charAt(x), x+1);
        }
        
    }
    public List<String> AllPossibleStrings(String s)
    {
        List<String> res = new ArrayList<>();
        generate(res,s,"",0);
        Collections.sort(res);
        return res;
    }
}