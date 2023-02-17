import java.util.*;
import java.io.*;
 
class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;
 
    Graph(int v) {
        this.vertices = v+1;
        adjList = new ArrayList[v+1];
        
        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }
 
    void addEdge(int v, int w) {
        adjList[v].add(w);
     
    }
 
    void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        //visited array to make sure not visiting a vertex more than once.
        boolean visited[] = new boolean[vertices];
        q.add(0);
        visited[0] = true;
        //BFS
        while (q.size() > 0) {
            int curr = q.remove();
            System.out.print(curr + " ");
            visited[curr] = true;
            for (int nbr : adjList[curr]) {
                if(!visited[nbr]) {
                    q.add(nbr);
                    //mark as visited
                    visited[nbr] = true;
                }
            }
        }
    }
}
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
