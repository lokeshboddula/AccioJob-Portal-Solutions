import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }

  public static void destroyWithDFS (int row, int col, int[][] grid, int[][] visited) {
	  if(row < 0 || row > grid.length - 1 ||
		 col < 0 || col > grid[0].length - 1 ||
		 grid[row][col] == 0 || visited[row][col] == 0) return;
	  
	  if(grid[row][col] == 1 && visited[row][col] != 2) visited[row][col] = 0;

		  destroyWithDFS (row - 1, col, grid, visited); //up
		  destroyWithDFS (row, col + 1, grid, visited); // right
		  destroyWithDFS (row + 1, col, grid, visited); // down
		  destroyWithDFS (row, col - 1, grid, visited); // left
  }
  public static int numEnclaves (int[][] grid) {
	  int n = grid.length;
	  int m = grid[0].length;
	  int[][] visited = grid;
	  int landCellsLeft = 0;

	  // traversing over boundary cells to eleminate the islands connected with them
    for (int i = 0; i < n; i++) {
			destroyWithDFS(i, 0, grid, visited);
			destroyWithDFS(i, m - 1, grid, visited);
	}
    for (int i = 0; i < n; i++) {
			destroyWithDFS(0, i, grid, visited);
			destroyWithDFS(n - 1, i, grid, visited);
	}
	  for (int i = 0; i < n; i++) {
		  for (int j = 0; j < m; j++) {
			  if (visited[i][j] == 1) landCellsLeft++;
		  }
	  }
	  return landCellsLeft;
  }
}