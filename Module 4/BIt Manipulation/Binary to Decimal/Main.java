import java.util.*;

class Accio{
    static int ASLoops6(String s){
		int n = s.length();
        int[] bits = new int[32];
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == '1') bits[i]++;
		}
		int pow = 1;
		int ans = 0;
		
		for(int i = n - 1; i >= 0; i--) {
			if(bits[i] == 1) {
				ans += pow;
			}
			pow *= 2;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Accio obj = new Accio();
        int ans=obj.ASLoops6(s);
        System.out.println(ans);
    }
}