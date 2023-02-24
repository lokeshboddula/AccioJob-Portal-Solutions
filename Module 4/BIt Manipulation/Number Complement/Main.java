import java.util.Scanner;

class Solution{
public static int findComplement(int num){
	int copy = num;
	int numberOfBits = 0;
		while (copy > 0) {
			numberOfBits++;
			copy >>= 1;
		}
		int temp = (1 << numberOfBits) - 1;
	 return temp ^ num;
    }
}
public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	System.out.println(Solution.findComplement(num));
	sc.close();
    }
}