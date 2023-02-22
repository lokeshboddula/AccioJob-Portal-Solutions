import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	  public static void main(String[] args) throws Throwable {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int q = sc.nextInt();
	        int [] arr= new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        int [][] queries= new int[q][2];
	        for(int i=0;i<q;i++){
	            for(int j=0;j<2;j++){
	                queries[i][j]=sc.nextInt();
	            }
	        }
	        Solution Obj= new Solution();
	        
	        int [] result = Obj.xorQueries(arr,queries);
	        for(int i=0;i<result.length;i++){
	            System.out.print(result[i]+" ");
		    }
	  }
}
class Solution{
	 public static int[] xorQueries(int[] A, int[][] queries) {
	    int[] ans = new int[queries.length];
		int pref[] = new int[A.length];
		pref[0] = A[0];
		for(int i = 1; i < A.length; i++) {
			pref[i] = pref[i - 1] ^ A[i];
		}
		 for(int i = 0; i< queries.length; i++) {
			 if(queries[i][0] == 0) {
				 ans[i] = pref[queries[i][1]];
			 } else {
				 ans[i]  = pref[queries[i][0] - 1] ^ pref[queries[i][1]];
			 }
		 }
		 return ans;
	}   
}