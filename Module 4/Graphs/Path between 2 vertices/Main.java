import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        Solution ob = new Solution();
        if (ob.check(N, M, Edges,U,V)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {
    boolean dfs(ArrayList<ArrayList<Integer>> graph,int U,int V, boolean visited[]) {
		if(U == V) {
			return true;
		}
		visited[U] = true;
		for(int nbr : graph.get(U)) {
			if(!visited[nbr]) {
				boolean hasPath =  dfs (graph, nbr, V, visited);
				if(hasPath) return true;
			}
			
		}
		visited[U] = false;
		return false;
	}
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges,int U,int V) {
		boolean visited[] = new boolean[N + 1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());

		for(ArrayList<Integer> edge : Edges) {
			int a = edge.get(0);
			int b = edge.get(1);
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		return dfs(graph, U, V, visited);
    }
}