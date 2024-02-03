//{ Driver Code Starts
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

class LinkedList1
{
    Node head;  // head of lisl
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String s = sc.nextLine();
        while(t>0)
        {
            int n = sc.nextInt();
            String s1 = sc.nextLine();
            LinkedList1 llist = new LinkedList1();

            if (n > 0)
            {
                int a1=sc.nextInt();
                Node head= new Node(a1);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            System.out.println(new Solution().DecimalValue(llist.head));
            t--;
        }
    }
}


// } Driver Code Ends


class Solution
{
   long DecimalValue(Node head)
   {
       int mod = (int)1e9+7;
 	    List<Integer> list = new ArrayList<>();
 	    while(head!=null){
 	        list.add(head.data);
 	        head = head.next;
 	    }
 	    long res = 0;
 	    long count = 1;
 	    for(int i=list.size()-1; i>=0; i--){
 	        if(list.get(i)==1) res=(res+count)%mod;
 	        count=(count*2)%mod;
 	    }
 	    return res%mod;
   }
}