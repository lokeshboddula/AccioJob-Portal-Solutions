import java.util.*;

class Solution {
        public int[] sumQuery(int[] arr, int[][] ranges) {
            int pref[] = new int[arr.length];
			int ans[] = new int[ranges.length];
			pref[0] = arr[0];
			//building pref sum array
			for(int i = 1; i < arr.length; i++) {
				pref[i] = pref[i - 1] + arr[i];
			}
			for(int i = 0; i < ranges.length; i++) {
				if(ranges[i][0] != 0) {
					ans[i] = pref[ranges[i][1]] - pref[ranges[i][0] - 1];
				} else {
					ans[i] = pref[ranges[i][1]];
				}
			}
			return ans;
        }
}

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}