
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
		//code here
		// car travel space
		int[] stops = new int[1001];
		//adding and removing passengers at respective stops
		for (int i = 0; i < trips.length; i++) {
			stops[trips[i][1]] += trips[i][0];
			stops[trips[i][2]] -= trips[i][0];
		}
		//creating prefix step array
		for (int i = 1; i < 1001; i++) {
			stops[i] = stops[i] + stops[i - 1];
		}
	    	// checking if the capacity is exceeded at any stop
		for (int i = 1; i < 1001; i++) {
			if (stops[i] > capacity) return false;
		}
	return true;

	}
}
