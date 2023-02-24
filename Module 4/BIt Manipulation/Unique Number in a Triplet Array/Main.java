import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int singleNumber(int[] nums) {
    int[] bits = new int[32];
	for (int i = 0; i < nums.length; i++) {
		int bit = 0;
		int n = nums[i];
		while(bit < 32) {
			if((n & 1) == 1) {
				bits[bit]++;
			}
			bit++;
			n = n >> 1;
		}	
	}
		int ans = 0;
		int pow = 1;
	for (int i = 0; i < 32; i++) {
		if(bits[i] % 3 == 1) ans += pow; // 0th bit will geive 1 and so on they give 2'pow
		pow*=2;
	}
		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}