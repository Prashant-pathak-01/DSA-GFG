//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void generate(List<String> list,String str, String res){
        if(str.length()==0){
            list.add(res);
        }
        for(int i=0; i<str.length(); i++){
            boolean flag = true;
            for(int x=i+1; x<str.length(); x++){
                if(str.charAt(x)==str.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) generate(list,str.substring(0,i)+str.substring(i+1),res+str.charAt(i));
        }
    }
    public List<String> find_permutation(String S) {
        List<String > res = new ArrayList<>();
        char arr[] = S.toCharArray();
        Arrays.sort(arr);
        S = "";
        for(char i:arr) S = S+i;
        generate(res,S,"");
        return res;
    }
}