import java.util.*;

class Solution{
    public static int countBitsFlip(int a, int b){
       int c = a ^ b;
		int count = 0;
		while (c > 0) {
			if((c & 1) == 1) count++;
			c >>= 1;
		}
		return count;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(Solution.countBitsFlip(a,b));
    }
}