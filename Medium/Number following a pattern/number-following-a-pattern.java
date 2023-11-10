//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        StringBuilder res = new StringBuilder();
        int temp = 1;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='I'){
                res.append(String.valueOf(temp));
                temp++;
            } else{
                int count = 0;
                while(i<S.length() && S.charAt(i)=='D'){
                    count++;
                    i++;
                     
                }
                int store = temp+1+count;
                while(count>=0){
                    res.append(String.valueOf(temp+count));
                    count--;
                }
                temp = store;
            }
        }
        if(S.charAt(S.length()-1)=='I') res.append(temp);
        return res.toString();
    }
}
