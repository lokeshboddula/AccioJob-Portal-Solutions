import java.util.*;

class Solution {
	static class Pair {
		int first;
		int second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
  static void dfs(boolean[][] visited, int[][] grid, int row, 
				  int col, int i, int j, HashSet<ArrayList<String>> set, ArrayList<String> list) {
	  if(row < 0 || row > grid.length - 1 ||
		 col < 0 || col > grid[0].length - 1 || grid[row][col] == 0 || visited[row][col]) return;
	   visited[row][col] = true;
	  if(grid[row][col] == 1) {
		  list.add((row - i) + " " + (col - j));
		  dfs(visited, grid, row - 1, col, i , j, set, list);
		  dfs(visited, grid, row, col + 1, i , j, set, list);
		  dfs(visited, grid, row + 1, col, i , j, set, list);
		  dfs(visited, grid, row, col - 1, i , j, set, list);
	  }
  }
  
  public static int countDistinctIslands(int[][] grid) {
	  int n = grid.length;
	  int m = grid[0].length;
	  int count = 0;
	  //System.out.println(n + " " + m);
     boolean[][] visited = new boolean[n][m];
	  HashSet<ArrayList<String>> set = new HashSet<>();
	  
	 for(int i = 0; i < n; i++) {
		 for (int j = 0; j < m; j++) {
			 ArrayList<String> list = new ArrayList<>();
			 if(!visited[i][j] && grid[i][j] == 1) {
				 count++;
				 dfs(visited, grid, i, j, i, j, set, list);
				 set.add(list);
			 } 
		 }
	 }
	 // for(ArrayList<String> p : set) {
		// 	 System.out.print(p);
	 // }
	return set.size();
  }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}