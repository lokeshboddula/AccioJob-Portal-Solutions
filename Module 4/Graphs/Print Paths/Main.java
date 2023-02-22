import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
	static void dfs (ArrayList<Edge>[]graph , int src , int dest , boolean visited[], String psf) {
		if(src == dest) {
			System.out.println(psf);
			return;
		}
		visited[src] = true;
		for(Edge e : graph[src]) {
			if(!visited[e.nbr]) dfs (graph, e.nbr, dest, visited, psf + e.nbr);
		}
		visited[src] = false;
	}
   public static void printAllPath(ArrayList<Edge>[]graph , int src , int dest , int n){ 
	   boolean visited[] = new boolean[n];
      dfs(graph, src, dest, visited, src + "");
   }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      printAllPath(graph,src,dest,vtces);
   }


}