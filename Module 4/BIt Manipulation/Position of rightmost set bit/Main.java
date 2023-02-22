import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        Solution obj=new Solution();
        int ans=obj.solve(n);
        System.out.println(ans);
    }
}

class Solution{
    
    static int solve(int n)
    {
        int k = 0;
		// we go right with 
		while((n & 1<<k) == 0) {
			k++;
		}
       return k + 1;
    }
}