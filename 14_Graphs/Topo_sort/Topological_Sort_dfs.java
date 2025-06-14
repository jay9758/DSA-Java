//https://www.geeksforgeeks.org/problems/topological-sort/1

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological_Sort_dfs {

    public static void dfs(List<List<Integer>> adj,int[] vis,Stack<Integer> st,int node){
        vis[node]=1;
        
        for (int it : adj.get(node)) {
            if (vis[it]==0) {
                dfs(adj, vis, st, it);
            }
        }
        st.add(node);
    }

    public static List<Integer> topoSort(List<List<Integer>> adj){
        int n=adj.size();
        int[] vis=new int[n];
        Stack<Integer> st=new Stack<>();
        List<Integer> ans=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i]==0) {
                dfs(adj,vis,st,i);
            }
        }
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        int V=6;
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        List<Integer> ans=new ArrayList<>();
        ans=topoSort(adj);
        System.out.println(ans);
    }
}
