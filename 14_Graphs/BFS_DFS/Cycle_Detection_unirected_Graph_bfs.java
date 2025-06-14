//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int node;
    int parent;

    Pair(int node,int parent) {
        this.node=node;
        this.parent=parent;
    }
}

public class Cycle_Detection_unirected_Graph_bfs {

    public static boolean checkCycle(int st,int V,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[st]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(st, -1));
        while (!q.isEmpty()) {
            int node=q.peek().node;
            int parent=q.peek().parent;
            q.poll();

            for (int adjNode : adj.get(node)) {
                if (vis[adjNode]==false) {
                    vis[adjNode]=true;
                    q.add(new Pair(adjNode, node));
                }
                else if (parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis=new boolean[V+1];
        for (int i = 0; i <= V; i++) {
            vis[i]=false;
        }
        for (int i = 0; i < V; i++) {
            if (vis[i]==false) {
                if(checkCycle(i,V,adj,vis)){
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

        boolean ans=isCycle(V,adj);
        System.out.println(ans);
    }
}
