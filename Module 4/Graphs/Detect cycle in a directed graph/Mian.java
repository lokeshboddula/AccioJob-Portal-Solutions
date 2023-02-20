import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	boolean dfs (int curr, boolean[] visited, boolean[] path, ArrayList<Integer>[] graph) {
		visited[curr] = true;
		path[curr] = true;
		for (int nbr : graph[curr]) {
			if(visited[nbr] && path[nbr]) return true;
			boolean isThereAnyCycle = dfs (nbr, visited, path, graph);
			if (isThereAnyCycle) return true;
		}
		path[curr] = false;
		return false;
	}
public boolean isCyclic(int V, ArrayList<Integer>[] graph) {
     boolean[] visited = new boolean[V];
     boolean[] path = new boolean[V];
	for(int i = 0; i < V; i++) {
		if(visited[i]) continue;
		boolean isCyclic = dfs (i, visited, path, graph);
		if(isCyclic) return true;
	}
	return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}