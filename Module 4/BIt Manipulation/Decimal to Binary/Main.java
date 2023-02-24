import java.util.*;
import java.io.*;

class Main{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        Solution obj = new Solution();
        obj.toBinary(N);
        System.out.println();
    
	}
}

class Solution{
	void toBinary(int N) {
		StringBuilder s = new StringBuilder();
		while (N > 0) {
			s.insert(0, (N & 1));
			N >>= 1;
		}
        System.out.println(s);
	}
}