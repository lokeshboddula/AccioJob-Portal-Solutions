import java.util.*;

class Solution {
    public void binaryRepresentation(int n) {
        Queue<String> q = new LinkedList<>();
		q.add("1");
		while(n-- > 0) {
			String s = q.remove();
			System.out.print(s +" ");
			q.add(s + "0");
			q.add(s + "1");
		}         
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Solution Obj = new Solution();
        Obj.binaryRepresentation(n);
        sc.close();
    }
}


