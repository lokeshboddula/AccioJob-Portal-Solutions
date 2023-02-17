import java.util.*;

class Solution {
	public static void dfs (List<List<Integer>> graph, boolean visited[], int currNode) {
		visited[currNode] = true;
		System.out.print(currNode + " ");
		List<Integer> curr = graph.get(currNode);
		Collections.sort(curr);
		for (int i : curr) {
			if(!visited[i]) dfs(graph, visited, i);
		}
	}
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //construct Graph
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
		for (List<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		boolean visited[] = new boolean[n];
		dfs(graph, visited, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}