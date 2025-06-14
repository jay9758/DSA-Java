//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

import java.util.ArrayList;
import java.util.List;

public class Cycle_Detection_in_Directed_Graph_dfs {

    public static boolean dfs(List<List<Integer>> adj,int[] vis,int[] Pathvis,int node){
        int n=adj.size();
        vis[node]=1;
        Pathvis[node]=1;

        for (int it : adj.get(node)) {
            if (vis[it]==0) {
                if (dfs(adj, vis, Pathvis, it)==true) {
                    return true;
                }
            }
            else if (Pathvis[it]==1) {
                return true;
            }
        }
        Pathvis[node]=0;
        return false;
    }

    public static boolean detectCycle(List<List<Integer>> adj){
        int n=adj.size();
        int[] vis=new int[n];
        int[] Pathvis=new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i]==0) {
                if (dfs(adj,vis,Pathvis,i)==true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V=10;
        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(2);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        boolean ans=detectCycle(adj);
        System.out.println(ans);
    }
}
