import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums) {
        // write code her
		int[] ans = new int[2];
		int xorOfNums = 0;
		for (int num : nums) {
			xorOfNums ^= num;
		}
		int k = 0;
		while ((xorOfNums & 1<<k) == 0) k++;
		k = 1 << k;
		int setWithKthBitSet = 0;
		int setWithKthBitNotSet = 0;

		for(int num : nums) {
			if((num & k) == 0) {
				setWithKthBitSet ^= num;
			} else {
				setWithKthBitNotSet ^= num;
			}
		}
		
		if(setWithKthBitSet < setWithKthBitNotSet) {
			ans[0] = setWithKthBitSet;
			ans[1] = setWithKthBitNotSet;
		} else {
			ans[0] = setWithKthBitNotSet;
			ans[1] = setWithKthBitSet;
		}
		
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}