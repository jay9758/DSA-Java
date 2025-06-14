//https://www.naukri.com/code360/problems/cycle-detection-in-undirected-graph_1062670?leftPanelTabValue=SUBMISSION

import java.util.ArrayList;

public class Cycle_Detection_unirected_Graph_dfs {

    public static boolean checkCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                if (checkCycle(it, node, adj, vis) == true) {
                    return true;
                }
            } else if (parent != it) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V+1];
        for (int i = 0; i <= V; i++) {
            if (vis[i] == false) {
                if (checkCycle(i, -1, adj, vis) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) { 
        int V=3;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(1).add(3);
        adj.get(3).add(1);
        
        boolean ans = isCycle(V, adj);
        System.out.println(ans);
        System.out.println(adj);
    }
}
