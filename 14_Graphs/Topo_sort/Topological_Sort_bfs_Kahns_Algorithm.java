//https://www.geeksforgeeks.org/problems/topological-sort/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topological_Sort_bfs_Kahns_Algorithm {

    public static void bfs(List<List<Integer>> adj, int[] indgree, Queue<Integer> q, List<Integer> ans) {
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int it : adj.get(node)) {
                indgree[it]--;
                if (indgree[it] == 0) {
                    q.add(it); 
                }
            }
        }
    }

    public static List<Integer> topoSort(List<List<Integer>> adj) {
        int n = adj.size();
        int[] indgree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indgree[it]++;
            }
        }
        for (int i = 0; i < indgree.length; i++) {
            if (indgree[i] == 0) {
                q.offer(i);
            }
        }
        bfs(adj, indgree, q, ans);
        return ans;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        List<Integer> ans = new ArrayList<>();
        ans = topoSort(adj);
        System.out.println(ans);
    }
}
