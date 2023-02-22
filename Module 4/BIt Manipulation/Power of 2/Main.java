import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        //if no of set bits is 1 then it is a power of 2
		int setbits = 0;
		while (n > 0) {
			setbits++;
			n &= (n - 1);
		}
		return setbits == 1;
    }
}