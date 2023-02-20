import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int canFinish(int n, int[][] pre) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[n];
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		int[] levels = new int[n];
        for (int i = 0; i < pre.length; i++) {
			int ai = pre[i][0];
			int bi = pre[i][1];
			graph.get(bi).add(ai);
			indegree[ai]++;
		}
		Queue<Integer> q = new LinkedList<>();		
		for (int i = 0; i < n; i++) if(indegree[i] == 0) q.add(i);

		boolean visited[] = new boolean[n];
		int count = 0;
		while (q.size() > 0) {
			int curr = q.remove();
			count++;
			for(int nbr : graph.get(curr)) {
				indegree[nbr]--;
				if(indegree[nbr] == 0) q.add(nbr);
			}
		}
		if (count < n) return 0;
		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}