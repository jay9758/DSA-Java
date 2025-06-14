//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

import java.util.ArrayList;
import java.util.Arrays;

class dfs {

    public static void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        vis[node]=true;
        ans.add(node);

        for (int it : adj.get(node)) {
            if (vis[it]==false) {
                dfs(it, vis, adj, ans);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2,3,1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0,4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        int n=adj.size();
        int node=0;
        boolean[] vis=new boolean[n];
        ArrayList<Integer> ans=new ArrayList<>();

        dfs(node,vis,adj,ans);
        System.out.println(ans);
    }
}