//https://leetcode.com/problems/is-graph-bipartite/submissions/1661844385/

import java.util.ArrayList;
import java.util.List;

public class Bipartite_Graph {

    public static boolean dfs(List<List<Integer>> adj, int[] vis, int node) {
        int n = adj.size();

        for (int it : adj.get(node)) {
            if (vis[it] == -1) {
                vis[it] = 1 - vis[node];
                if (!dfs(adj, vis, it)) {
                    return false;
                }
            } 
            else if (vis[it] == vis[node]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(List<List<Integer>> adj) {
        int n = adj.size();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            vis[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                vis[i] = 0;
                if (!dfs(adj, vis, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 8;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(2).add(6);
        adj.get(6).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(7);
        adj.get(7).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(7).add(8);

        adj.get(8).add(7);

        // System.out.println(adj);
        boolean ans = isBipartite(adj);
        System.out.println(ans);
    }
}
