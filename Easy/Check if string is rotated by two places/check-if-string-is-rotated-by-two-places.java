//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        if(str1.length()!=str2.length()) return false;
        if(str1.length()==1) {
            if(str1.charAt(0)==str2.charAt(0)) return true;
            else return false;
            
        }
        boolean res= true;
        for(int i=0; i<str2.length()-2; i++){
            if(str1.charAt(i+2)!=str2.charAt(i)) res=false;
        }
        if(str1.charAt(0)!=str2.charAt(str2.length()-2) || str1.charAt(1)!=str2.charAt(str2.length()-1)) res = false;
        if(res==true) return true;
        
        for(int i=0; i<str2.length()-2; i++){
            if(str2.charAt(i+2)!=str1.charAt(i)) return false;
        }
        if(str2.charAt(0)!=str1.charAt(str2.length()-2) || str2.charAt(1)!=str1.charAt(str2.length()-1)) return false;
        return true;
        
    }
    
}