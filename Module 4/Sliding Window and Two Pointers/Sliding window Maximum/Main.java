import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int n, int k, int[] arr){
        int[] ans = new int [n - k + 1];
		int sp = 0;
		int e = 0;
		Deque<Integer> dq = new LinkedList<>();
		//creating window and adding first ans
		while (e < k) {
			while(dq.size() > 0 && arr[dq.getLast()] < arr[e]) dq.removeLast(); 
			dq.addLast(e);
			e++;
		}
		ans[0] = arr[dq.getFirst()];

		while (e < n) {
			sp++;
			while(dq.size() > 0 && arr[dq.getLast()] < arr[e]) dq.removeLast(); 
			dq.addLast(e);			
			e++;
			
			while(dq.getFirst() < sp) dq.removeFirst(); 

			ans[sp] = arr[dq.getFirst()];
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
