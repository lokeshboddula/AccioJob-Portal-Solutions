import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {
	public void build(int pref[][], int arr[][]) {
		// building prefix sum 2D array
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j <arr[0].length; j++) {
				int A = arr[i][j];
				int B = j - 1 >= 0 ? pref[i][j - 1] : 0;
				int C = i - 1 >= 0 ? pref[i - 1][j] : 0;
				int D = i - 1 >= 0 && j - 1 >= 0 ? pref[i - 1][j - 1] : 0;
				pref[i][j] = A + B + C - D;
			}
		}
	}
    public List<Integer> solve(int arr[][], Pair q[]) {
        // Your code here
        List<Integer> ans = new ArrayList<>();
		int n = arr.length;
		int m = arr[0].length;
		int[][] pref = new int[n][m];
		// building prefix sum 2D array
		build(pref, arr);

		// getting answers for queries
		for(int i = 0; i < q.length; i++) {
			int r1 = q[i].row1;
			int c1 = q[i].col1;
			int r2 = q[i].row2;
			int c2 = q[i].col2;
			int A = pref[r2][c2];
			int B = c1 - 1 >= 0 ? pref[r2][c1 - 1] : 0;
			int C = r1 - 1 >= 0 ? pref[r1 - 1][c2] : 0;
			int D = r1 - 1 >= 0 && c1 - 1 >= 0 ? pref[r1 - 1][c1 - 1] : 0;
			int result = A - B - C + D;
			ans.add(result);
		}
		return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}