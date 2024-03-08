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
            Solution ob = new Solution();
            long ans = ob.prime_Sum(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++) if(n%i==0) return false;
        return true;
    }
    public long prime_Sum(int n)
    {
        long res = 0;
        for(int i=2; i<=n; i++){
            if(isPrime(i)) res+=i;
        }
        return res;
    }
}