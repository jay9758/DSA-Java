//https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626?leftPanelTabValue=SUBMISSION

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//using Kahn's Algorithm
public class Cycle_Detection_in_Directed_Graph_bfs {

    public static boolean detectCycle(List<List<Integer>> adj){
        int n = adj.size();
        int[] indgree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indgree[it]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (indgree[i] == 0) {
                q.offer(i);
            }
        }

        int cnt=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for (int it : adj.get(node)) {
                indgree[it]--;
                if (indgree[it] == 0) {
                    q.add(it); 
                }
            }
        }

        if (cnt==n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int V=5;
        List<List<Integer>> adj=new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(2);
        
        boolean ans=detectCycle(adj);
        System.out.println(ans);
    }
}
