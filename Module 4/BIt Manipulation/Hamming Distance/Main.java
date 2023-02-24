import java.util.*;

class Accio{
    static int HammingDistance(int a,int b){
        int c = a ^ b;
		int count = 0;
		while (c > 0) {
			if ((c & 1) == 1) count++;
			c >>= 1;
 		}
		return count;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Accio obj = new Accio();
        int ans=obj.HammingDistance(a,b);
        System.out.println(ans);
    }
}
