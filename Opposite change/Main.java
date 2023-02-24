import java.util.*;
 
class Solution {
 
    public int Opposite(int n) {
        int copy = n;
		int noOfBits = 0;
		while (copy > 0) {
			noOfBits++;
			copy >>= 1;
		}
		int temp = (1 << noOfBits) - 1;
		return temp ^ n;
    }
}
 
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.Opposite(n));
    }
}