//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class bfs {

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int n=adj.size();
        ArrayList<Integer> ans=new ArrayList<>();
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        vis[0]=true;

        while (!q.isEmpty()) {
            int v=q.poll();
            for (int it : adj.get(v)) {
                if (vis[it]==false) {
                    q.offer(it);
                    vis[it]=true;
                }
            }
            ans.add(v);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2,3,1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0,4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        ArrayList<Integer> ans=bfs(adj);
        System.out.println(ans);
    }
}