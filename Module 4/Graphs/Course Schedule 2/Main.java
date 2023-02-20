Course Schedule 2import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] pre) {
	    //creating graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        //adding empty lists
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        //indegree array for for marking each nodes indegree 
        //and adding them to queue when the values becomes 0
        int indegree[] = new int[n];
        for (int i = 0; i < pre.length; i++) {
            int ai = pre[i][0];
            int bi = pre[i][1];
            graph.get(bi).add(ai);
            indegree[ai]++;
        }
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();
        //adding courses with 0 indegree
        for (int i = 0; i < n; i++) if (indegree[i] == 0) q.add(i);
        int idx = 0;
        while (q.size() > 0) {
            int curr = q.remove();
            ans[idx] = curr;
            idx++;
            for (int nbr : graph.get(curr)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.add(nbr);
            }
        }
        //if all courses are not doable (all nodes are not added to queue)
        if(idx < n) return new int[0];
        return ans;
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
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}