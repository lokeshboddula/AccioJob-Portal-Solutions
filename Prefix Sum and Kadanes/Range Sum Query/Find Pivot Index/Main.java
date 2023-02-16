import java.util.*;

class Solution {
    public int pivotIndex(int[] nums) {
        int[] pref = new int[nums.length];
		pref[0] = nums[0];
		//build pref sum array
		for (int i = 1; i < nums.length; i++) {
			pref[i] = pref[i - 1] + nums[i];
		}
		// finding pivot index
		for (int i = 0; i < nums.length; i++) {
			// if pivot is 0th index
			if(i == 0 && (pref[nums.length - 1] - pref[0]) == 0) {
				return i;
			}
			// if pivot is n - 1 th index
			else if(i == nums.length - 1 && pref[i - 1] == 0) {
				return i;
			}
			//otherwise
			else if((i > 0) && pref[i - 1] == (pref[nums.length - 1] - pref[i])) {
				return i;
			}
		}
        // pivot not found
		return -1;
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
        Solution Obj = new Solution();
        int result = Obj.pivotIndex(arr);
        System.out.println(result);
        sc.close();
    }
}