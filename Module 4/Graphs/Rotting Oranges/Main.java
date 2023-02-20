import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	
	  public static void main (String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int [][] arr= new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                arr[i][j]=sc.nextInt();
	            }
	        }
	        Solution obj= new Solution();
	        
	        System.out.println(obj.orangesRotting(arr));
		}
}
class Solution {
    class Pair {
        int row;
        int col;
        int time;
        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //count of fresh oranges initially
        int freshCount = 0;
        //max time taken
        int maxTime = 0;
        //visited array
        int[][] visited = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        //adding the initial rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair (i, j , 0));
                    //marking as visited
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 1;
                }
                //initial fesh orange count
                if (grid[i][j] == 1) freshCount++;
            }
        }
        int count = 0;
        //helper arrays to traverse in 4 directions -- up down right left
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        //BFS
        while (q.size() > 0) {
            int crow = q.peek().row;
            int ccol = q.peek().col;
            int ctime = q.peek().time;
            Pair curr = q.remove();
            //storing maxTime
            maxTime = Math.max(maxTime, ctime);
            //traversing in 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = crow + drow[i];
                int ncol = ccol + dcol[i];
                // visiting neighours with fresh oranges
                if (nrow >= 0 && nrow < n && ncol >= 0 && 
                ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] != 2) {
                    visited[nrow][ncol] = 2;
                    q.add(new Pair (nrow, ncol, ctime + 1));
                    //counting fresh oranges addded to the queue
                    count++;
                }
            }
        }
        //checking if alll fresh oranges are rotten or not
        if (freshCount != count) return -1;
        //returing maxTime that can be taken to rot all oranges
        return maxTime;
    }
}